
bool isAlreadyConvex(orcalines,relativePosition1,relativePosition2,invTimeHorizonObst,radius){
	for (size_t j = 0; j < orcaLines_.size(); ++j) {
		if (det(invTimeHorizonObst * relativePosition1 - orcaLines_[j].point, orcaLines_[j].direction) - invTimeHorizonObst * radius_ >= -RVO_EPSILON && det(invTimeHorizonObst * relativePosition2 - orcaLines_[j].point, orcaLines_[j].direction) - invTimeHorizonObst * radius_ >=  -RVO_EPSILON) {
			return = true;
		}
	}
	return false;
}