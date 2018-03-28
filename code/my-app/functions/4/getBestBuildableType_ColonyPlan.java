public BuildableType getBestBuildableType() {
    BuildPlan bp = find(buildPlans, p -> colony.canBuild(p.type));
    return (bp == null) ? null : bp.type;
}