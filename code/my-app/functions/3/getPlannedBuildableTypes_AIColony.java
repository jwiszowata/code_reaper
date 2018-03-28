public List<BuildableType> getPlannedBuildableTypes() {
    return (colonyPlan == null) ? Collections.<BuildableType>emptyList() : colonyPlan.getBuildableTypes();
}