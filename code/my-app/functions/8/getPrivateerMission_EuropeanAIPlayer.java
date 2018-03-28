public Mission getPrivateerMission(AIUnit aiUnit, Location target) {
    if (PrivateerMission.invalidReason(aiUnit) != null)
        return null;
    if (target == null) {
        target = PrivateerMission.findTarget(aiUnit, privateerRange, true);
    }
    return (target == null) ? null : new PrivateerMission(getAIMain(), aiUnit, target);
}