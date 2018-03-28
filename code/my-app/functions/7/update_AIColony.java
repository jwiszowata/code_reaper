public void update(LogBuilder lb) {
    lb.add("\n  ", colony.getName());
    resetExports();
    updateExportGoods(lb);
    updateTileImprovementPlans(lb);
    updateWishes(lb);
}