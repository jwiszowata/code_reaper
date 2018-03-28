public Mission getBuildColonyMission(AIUnit aiUnit, Location target) {
    String reason = BuildColonyMission.invalidReason(aiUnit);
    if (reason != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    if (target == null) {
        target = BuildColonyMission.findTarget(aiUnit, buildingRange, unit.isInEurope());
    }
    return (target == null) ? null : new BuildColonyMission(getAIMain(), aiUnit, target);
}