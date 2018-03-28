public List<BuildableType> getBuildableTypes() {
    return transform(buildPlans, alwaysTrue(), bp -> bp.type);
}