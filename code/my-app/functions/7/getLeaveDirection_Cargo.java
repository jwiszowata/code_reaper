public Direction getLeaveDirection() {
    if (!carrier.hasTile() || plan.cdst == plan.tdst)
        return null;
    TransportableAIObject t = getTransportable();
    PathNode path = t.getDeliveryPath(getCarrier(), plan.tdst);
    return (path == null || path.next == null) ? null : path.next.getDirection();
}