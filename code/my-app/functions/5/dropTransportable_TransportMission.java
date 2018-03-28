private void dropTransportable(TransportableAIObject t) {
    AIUnit carrier = getAIUnit();
    if (t.getTransport() == carrier)
        t.setTransport(null);
}