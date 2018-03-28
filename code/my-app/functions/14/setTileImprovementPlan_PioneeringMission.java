public void setTileImprovementPlan(TileImprovementPlan tip) {
    TileImprovementPlan old = tileImprovementPlan;
    this.tileImprovementPlan = tip;
    AIUnit aiUnit = getAIUnit();
    if (old != tileImprovementPlan) {
        if (old != null && old.getPioneer() == aiUnit) {
            old.setPioneer(null);
        }
        if (tileImprovementPlan != null) {
            tileImprovementPlan.setPioneer(aiUnit);
            getEuropeanAIPlayer().removeTileImprovementPlan(tip);
        }
    }
}