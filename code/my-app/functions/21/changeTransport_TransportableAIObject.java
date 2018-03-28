public boolean changeTransport(AIUnit aiCarrier) {
    Location now;
    Locatable l = getTransportLocatable();
    if (l != null && (now = l.getLocation()) instanceof Unit && !(aiCarrier != null && aiCarrier.getUnit() == now)) {
        if (!leaveTransport())
            return false;
    }
    AIUnit old = getTransport();
    if (old != null) {
        if (old == aiCarrier)
            return true;
        TransportMission tm = old.getMission(TransportMission.class);
        if (tm != null)
            tm.removeTransportable(this);
    }
    setTransport(null);
    if (aiCarrier != null) {
        setTransport(aiCarrier);
    }
    return true;
}