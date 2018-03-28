private boolean prioritize(BuildableType type, double weight, double support) {
    BuildPlan bp = findBuildPlan(type);
    if (bp == null) {
        buildPlans.add(new BuildPlan(type, weight, support));
        return true;
    }
    if (bp.weight * bp.support < weight * support) {
        bp.weight = weight;
        bp.support = support;
        return true;
    }
    return false;
}