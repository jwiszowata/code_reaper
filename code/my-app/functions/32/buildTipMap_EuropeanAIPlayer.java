public void buildTipMap(LogBuilder lb) {
    tipMap.clear();
    for (AIColony aic : getAIColonies()) {
        for (TileImprovementPlan tip : aic.getTileImprovementPlans()) {
            if (tip == null || tip.isComplete()) {
                aic.removeTileImprovementPlan(tip);
            } else if (tip.getPioneer() != null) {
            } else if (!tip.validate()) {
                aic.removeTileImprovementPlan(tip);
                tip.dispose();
            } else if (tip.getTarget() == null) {
                logger.warning("No target for tip: " + tip);
            } else {
                TileImprovementPlan other = tipMap.get(tip.getTarget());
                if (other == null || other.getValue() < tip.getValue()) {
                    tipMap.put(tip.getTarget(), tip);
                }
            }
        }
    }
    if (!tipMap.isEmpty()) {
        lb.add("\n  Improvements:");
        forEachMapEntry(tipMap, e -> {
            Tile t = e.getKey();
            TileImprovementPlan tip = e.getValue();
            AIUnit pioneer = tip.getPioneer();
            lb.add(" ", t, "=", tip.getType().getSuffix());
            if (pioneer != null)
                lb.add("/", pioneer.getUnit());
        });
    }
}