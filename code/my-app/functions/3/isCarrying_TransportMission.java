private boolean isCarrying(TransportableAIObject t) {
    return t != null && t.getLocation() == getUnit();
}