private void updateGoodsTypeLists(Map<GoodsType, Map<WorkLocation, Integer>> production) {
    foodGoodsTypes.clear();
    libertyGoodsTypes.clear();
    immigrationGoodsTypes.clear();
    militaryGoodsTypes.clear();
    rawBuildingGoodsTypes.clear();
    buildingGoodsTypes.clear();
    rawLuxuryGoodsTypes.clear();
    luxuryGoodsTypes.clear();
    otherRawGoodsTypes.clear();
    for (GoodsType g : new ArrayList<>(production.keySet())) {
        if (g.isFoodType()) {
            foodGoodsTypes.add(g);
        } else if (g.isLibertyType()) {
            libertyGoodsTypes.add(g);
        } else if (g.isImmigrationType()) {
            immigrationGoodsTypes.add(g);
        } else if (g.getMilitary()) {
            militaryGoodsTypes.add(g);
        } else if (g.isRawBuildingMaterial()) {
            rawBuildingGoodsTypes.add(g);
        } else if (g.isBuildingMaterial() && g.getInputType().isRawBuildingMaterial()) {
            buildingGoodsTypes.add(g);
        } else if (g.isNewWorldGoodsType()) {
            rawLuxuryGoodsTypes.add(g);
        } else if (g.isRefined() && g.getInputType().isNewWorldGoodsType()) {
            luxuryGoodsTypes.add(g);
        } else if (g.isFarmed()) {
            otherRawGoodsTypes.add(g);
        } else {
            logger.warning("Ignoring goods type " + g + " at " + colony.getName());
            production.remove(g);
        }
    }
}