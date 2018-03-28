public Mission getPioneeringMission(AIUnit aiUnit, Location target) {
    if (PioneeringMission.prepare(aiUnit) != null)
        return null;
    if (target == null) {
        target = PioneeringMission.findTarget(aiUnit, pioneeringRange, true);
    }
    if (target == null) {
        Unit unit = aiUnit.getUnit();
        if (unit.isInEurope() || unit.getSettlement() != null) {
            aiUnit.equipForRole(getSpecification().getDefaultRole());
        }
        return null;
    }
    return new PioneeringMission(getAIMain(), aiUnit, target);
}