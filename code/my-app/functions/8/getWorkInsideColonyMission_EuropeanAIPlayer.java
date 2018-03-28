public Mission getWorkInsideColonyMission(AIUnit aiUnit, AIColony aiColony) {
    if (WorkInsideColonyMission.invalidReason(aiUnit) != null)
        return null;
    if (aiColony == null) {
        aiColony = getAIColony(aiUnit.getUnit().getColony());
    }
    return (aiColony == null) ? null : new WorkInsideColonyMission(getAIMain(), aiUnit, aiColony);
}