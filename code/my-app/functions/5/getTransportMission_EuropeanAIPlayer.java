public Mission getTransportMission(AIUnit aiUnit) {
    if (TransportMission.invalidReason(aiUnit) != null)
        return null;
    return new TransportMission(getAIMain(), aiUnit);
}