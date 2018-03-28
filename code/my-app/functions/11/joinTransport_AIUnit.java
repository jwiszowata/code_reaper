public boolean joinTransport(Unit carrier, Direction direction) {
    AIUnit aiCarrier = getAIMain().getAIUnit(carrier);
    if (aiCarrier == null)
        return false;
    boolean result = AIMessage.askEmbark(aiCarrier, unit, direction) && unit.getLocation() == carrier;
    if (result) {
        requestLocalRearrange();
        takeTransport();
    }
    return result;
}