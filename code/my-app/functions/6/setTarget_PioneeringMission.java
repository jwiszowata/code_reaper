public void setTarget(Location target) {
    if (target == null || target instanceof Colony || target instanceof Tile) {
        this.target = target;
        setTileImprovementPlan((target instanceof Tile) ? getBestPlan((Tile) target) : null);
    }
}