private void updateTipMap(AIColony aic) {
    for (TileImprovementPlan tip : aic.getTileImprovementPlans()) {
        tipMap.put(tip.getTarget(), tip);
    }
}