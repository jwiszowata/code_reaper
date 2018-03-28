public String planToString() {
    if (colonyPlan == null)
        return "No plan.";
    LogBuilder lb = new LogBuilder(256);
    lb.add(colonyPlan, "\n\nTILE IMPROVEMENTS:\n");
    for (TileImprovementPlan tip : getTileImprovementPlans()) {
        lb.add(tip, "\n");
    }
    lb.add("\n\nWISHES:\n");
    for (Wish w : getWishes()) lb.add(w, "\n");
    lb.add("\n\nEXPORT GOODS:\n");
    for (AIGoods aig : getExportGoods()) lb.add(aig, "\n");
    return lb.toString();
}