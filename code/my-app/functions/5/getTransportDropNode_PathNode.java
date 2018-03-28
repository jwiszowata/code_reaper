public PathNode getTransportDropNode() {
    PathNode p = this;
    while (p.next != null && p.isOnCarrier()) p = p.next;
    return p;
}