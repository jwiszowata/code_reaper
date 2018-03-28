private BuildPlan findBuildPlan(BuildableType type) {
    return find(buildPlans, bp -> bp.type == type);
}