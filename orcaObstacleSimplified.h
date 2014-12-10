for (size_t i = 0; i < obstacleNeighbors_.size(); ++i) {

			const Obstacle *obstacle1 = obstacleNeighbors_[i].second;
			const Obstacle *obstacle2 = obstacle1->nextObstacle_;

			const Vector2 relativePosition1 = obstacle1->point_ - position_;
			const Vector2 relativePosition2 = obstacle2->point_ - position_;

			/*
			 * Check if velocity obstacle of obstacle is already taken care of by
			 * previously constructed obstacle ORCA lines.
			 */

			if (!alreadyCovered(orcalines,relativePosition1,relativePosition2)) {
				
	
				/* Not yet covered. Check for collisions. */

				const float distSq1 = absSq(relativePosition1);
				const float distSq2 = absSq(relativePosition2);

				const float radiusSq = sqr(radius_);

				const Vector2 obstacleVector = obstacle2->point_ - obstacle1->point_;
				const float s = (-relativePosition1 * obstacleVector) / absSq(obstacleVector);
				const float distSqLine = absSq(-relativePosition1 - s * obstacleVector);

				Line line;

				if (s < 0.0f && distSq1 <= radiusSq) {
					/* Collision with left vertex. Ignore if non-convex. */
					if (obstacle1->isConvex_) {
						line.point = Vector2(0.0f, 0.0f);
						line.direction = normalize(Vector2(-relativePosition1.y(), relativePosition1.x()));
						orcaLines_.push_back(line);
					}
				}
				else if (s > 1.0f && distSq2 <= radiusSq) {
					/* Collision with right vertex. Ignore if non-convex
					 * or if it will be taken care of by neighoring obstace */
					if (obstacle2->isConvex_ && det(relativePosition2, obstacle2->unitDir_) >= 0.0f) {
						line.point = Vector2(0.0f, 0.0f);
						line.direction = normalize(Vector2(-relativePosition2.y(), relativePosition2.x()));
						orcaLines_.push_back(line);
					}
				}
				else if (s >= 0.0f && s < 1.0f && distSqLine <= radiusSq) {
					/* Collision with obstacle segment. */
					line.point = Vector2(0.0f, 0.0f);
					line.direction = -obstacle1->unitDir_;
					orcaLines_.push_back(line);
				}
				else{
					

					/*
					 * No collision.
					 * Compute legs. When obliquely viewed, both legs can come from a single
					 * vertex. Legs extend cut-off line when nonconvex vertex.
					 */

					Vector2 leftLegDirection, rightLegDirection;
					
					//rajout julian -- bool pour les continue lignes 168 et 184 
					bool ignore=false;

					if (s < 0.0f && distSqLine <= radiusSq) {
						/*
						 * Obstacle viewed obliquely so that left vertex
						 * defines velocity obstacle.
						 */
						if (!obstacle1->isConvex_) {
							/* Ignore obstacle. */
							ignore=true; // remplace continue;
						}
						else{
							obstacle2 = obstacle1;

							const float leg1 = std::sqrt(distSq1 - radiusSq);
							leftLegDirection = Vector2(relativePosition1.x() * leg1 - relativePosition1.y() * radius_, relativePosition1.x() * radius_ + relativePosition1.y() * leg1) / distSq1;
							rightLegDirection = Vector2(relativePosition1.x() * leg1 + relativePosition1.y() * radius_, -relativePosition1.x() * radius_ + relativePosition1.y() * leg1) / distSq1;
						}

						
					}
					else if (s > 1.0f && distSqLine <= radiusSq) {
						/*
						 * Obstacle viewed obliquely so that
						 * right vertex defines velocity obstacle.
						 */
						if (!obstacle2->isConvex_) {
							/* Ignore obstacle. */
							ignore=true; // remplace continue;
						}
						else{

							obstacle1 = obstacle2;

							const float leg2 = std::sqrt(distSq2 - radiusSq);
							leftLegDirection = Vector2(relativePosition2.x() * leg2 - relativePosition2.y() * radius_, relativePosition2.x() * radius_ + relativePosition2.y() * leg2) / distSq2;
							rightLegDirection = Vector2(relativePosition2.x() * leg2 + relativePosition2.y() * radius_, -relativePosition2.x() * radius_ + relativePosition2.y() * leg2) / distSq2;
						}
					}
					else {
						/* Usual situation. */
						if (obstacle1->isConvex_) {
							const float leg1 = std::sqrt(distSq1 - radiusSq);
							leftLegDirection = Vector2(relativePosition1.x() * leg1 - relativePosition1.y() * radius_, relativePosition1.x() * radius_ + relativePosition1.y() * leg1) / distSq1;
						}
						else {
							/* Left vertex non-convex; left leg extends cut-off line. */
							leftLegDirection = -obstacle1->unitDir_;
						}

						if (obstacle2->isConvex_) {
							const float leg2 = std::sqrt(distSq2 - radiusSq);
							rightLegDirection = Vector2(relativePosition2.x() * leg2 + relativePosition2.y() * radius_, -relativePosition2.x() * radius_ + relativePosition2.y() * leg2) / distSq2;
						}
						else {
							/* Right vertex non-convex; right leg extends cut-off line. */
							rightLegDirection = obstacle1->unitDir_;
						}
					}

					/*
					 * Legs can never point into neighboring edge when convex vertex,
					 * take cutoff-line of neighboring edge instead. If velocity projected on
					 * "foreign" leg, no constraint is added.
					 */

					if(!ignore){
						const Obstacle *const leftNeighbor = obstacle1->prevObstacle_;

						bool isLeftLegForeign = false;
						bool isRightLegForeign = false;

						if (obstacle1->isConvex_ && det(leftLegDirection, -leftNeighbor->unitDir_) >= 0.0f) {
							/* Left leg points into obstacle. */
							leftLegDirection = -leftNeighbor->unitDir_;
							isLeftLegForeign = true;
						}

						if (obstacle2->isConvex_ && det(rightLegDirection, obstacle2->unitDir_) <= 0.0f) {
							/* Right leg points into obstacle. */
							rightLegDirection = obstacle2->unitDir_;
							isRightLegForeign = true;
						}

						/* Compute cut-off centers. */
						const Vector2 leftCutoff = invTimeHorizonObst * (obstacle1->point_ - position_);
						const Vector2 rightCutoff = invTimeHorizonObst * (obstacle2->point_ - position_);
						const Vector2 cutoffVec = rightCutoff - leftCutoff;

						/* Project current velocity on velocity obstacle. */

						/* Check if current velocity is projected on cutoff circles. */
						const float t = (obstacle1 == obstacle2 ? 0.5f : ((velocity_ - leftCutoff) * cutoffVec) / absSq(cutoffVec));
						const float tLeft = ((velocity_ - leftCutoff) * leftLegDirection);
						const float tRight = ((velocity_ - rightCutoff) * rightLegDirection);

						if ((t < 0.0f && tLeft < 0.0f) || (obstacle1 == obstacle2 && tLeft < 0.0f && tRight < 0.0f)) {
							/* Project on left cut-off circle. */
							const Vector2 unitW = normalize(velocity_ - leftCutoff);

							line.direction = Vector2(unitW.y(), -unitW.x());
							line.point = leftCutoff + radius_ * invTimeHorizonObst * unitW;
							orcaLines_.push_back(line);
						}
						else if (t > 1.0f && tRight < 0.0f) {
							/* Project on right cut-off circle. */
							const Vector2 unitW = normalize(velocity_ - rightCutoff);

							line.direction = Vector2(unitW.y(), -unitW.x());
							line.point = rightCutoff + radius_ * invTimeHorizonObst * unitW;
							orcaLines_.push_back(line);
						}
						else{

							/*
							 * Project on left leg, right leg, or cut-off line, whichever is closest
							 * to velocity.
							 */
							const float distSqCutoff = ((t < 0.0f || t > 1.0f || obstacle1 == obstacle2) ? std::numeric_limits<float>::infinity() : absSq(velocity_ - (leftCutoff + t * cutoffVec)));
							const float distSqLeft = ((tLeft < 0.0f) ? std::numeric_limits<float>::infinity() : absSq(velocity_ - (leftCutoff + tLeft * leftLegDirection)));
							const float distSqRight = ((tRight < 0.0f) ? std::numeric_limits<float>::infinity() : absSq(velocity_ - (rightCutoff + tRight * rightLegDirection)));

							if (distSqCutoff <= distSqLeft && distSqCutoff <= distSqRight) {
								/* Project on cut-off line. */
								line.direction = -obstacle1->unitDir_;
								line.point = leftCutoff + radius_ * invTimeHorizonObst * Vector2(-line.direction.y(), line.direction.x());
								orcaLines_.push_back(line);
							}
							else if (distSqLeft <= distSqRight) {
								/* Project on left leg. */
								if (!isLeftLegForeign) {
									line.direction = leftLegDirection;
									line.point = leftCutoff + radius_ * invTimeHorizonObst * Vector2(-line.direction.y(), line.direction.x());
									orcaLines_.push_back(line);
								}
							}
							else {
								/* Project on right leg. */
								if (!isRightLegForeign) {
									line.direction = -rightLegDirection;
									line.point = rightCutoff + radius_ * invTimeHorizonObst * Vector2(-line.direction.y(), line.direction.x());
									orcaLines_.push_back(line);
								}
							}
						}
					}
				}
			}
		}