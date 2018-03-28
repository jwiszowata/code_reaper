public void removeTileImprovementPlan(TileImprovementPlan plan) {
    if (plan == null)
        return;
    if (plan.getTarget() != null)
        tipMap.remove(plan.getTarget());
    for (AIColony aic : getAIColonies()) {
        if (aic.removeTileImprovementPlan(plan))
            break;
    }
}