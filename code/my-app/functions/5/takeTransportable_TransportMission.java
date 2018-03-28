private void takeTransportable(TransportableAIObject t) {
    AIUnit carrier = getAIUnit();
    if (t.getTransport() != carrier)
        t.setTransport(carrier);
}