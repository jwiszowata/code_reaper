private void removeAIColony(AIColony aic) {
    final Colony colony = aic.getColony();
    Set<TileImprovementPlan> tips = new HashSet<>();
    for (Tile t : colony.getOwnedTiles()) {
        TileImprovementPlan tip = tipMap.remove(t);
        if (tip != null)
            tips.add(tip);
    }
    for (AIGoods aig : aic.getExportGoods()) {
        if (Map.isSameLocation(aig.getLocation(), colony)) {
            aig.changeTransport(null);
            aig.dispose();
        }
    }
    transportDemand.remove(colony);
    Set<Wish> wishes = new HashSet<>(aic.getWishes());
    for (AIUnit aiu : getAIUnits()) {
        PioneeringMission pm = aiu.getMission(PioneeringMission.class);
        if (pm != null) {
            if (tips.contains(pm.getTileImprovementPlan())) {
                logger.info(pm + " collapses with loss of " + colony);
                aiu.changeMission(null);
            }
            continue;
        }
        WishRealizationMission wm = aiu.getMission(WishRealizationMission.class);
        if (wm != null) {
            if (wishes.contains(wm.getWish())) {
                logger.info(wm + " collapses with loss of " + colony);
                aiu.changeMission(null);
            }
            continue;
        }
    }
}