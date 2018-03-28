private void takeTransport() {
    Unit carrier = unit.getCarrier();
    AIUnit aiCarrier = (carrier == null) ? null : getAIMain().getAIUnit(carrier);
    AIUnit transport = getTransport();
    if (transport != aiCarrier) {
        if (transport != null) {
            logger.warning("Taking different transport: " + aiCarrier);
            dropTransport();
        }
        setTransport(aiCarrier);
    }
}