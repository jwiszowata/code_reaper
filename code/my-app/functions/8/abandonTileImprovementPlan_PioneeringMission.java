private void abandonTileImprovementPlan() {
    if (tileImprovementPlan != null) {
        if (tileImprovementPlan.getPioneer() == getAIUnit()) {
            tileImprovementPlan.setPioneer(null);
        }
        setTileImprovementPlan(null);
    }
}