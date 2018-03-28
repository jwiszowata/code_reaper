private boolean checkTransport(TransportableAIObject t) {
    AIUnit aiCarrier = t.getTransport();
    if (aiCarrier == null)
        return false;
    TransportMission tm = aiCarrier.getMission(TransportMission.class);
    if (tm != null && tm.isTransporting(t))
        return true;
    t.changeTransport(null);
    return false;
}