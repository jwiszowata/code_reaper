public PathNode getCarrierMove() {
    for (PathNode p = this; p != null; p = p.next) {
        if (p.isOnCarrier())
            return p;
    }
    return null;
}