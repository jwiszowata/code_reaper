public boolean dropTransport() {
    AIUnit transport = getTransport();
    if (transport != null) {
        if (!transport.isDisposed() && getLocation() != transport.getUnit()) {
            TransportMission tm = transport.getMission(TransportMission.class);
            if (tm != null)
                tm.removeTransportable(this);
        }
        setTransport(null);
    }
    return getTransport() == null;
}