public int adjustMission(AIUnit aiUnit, PathNode path, Class type, int value) {
    if (value > 0) {
        if (type == DefendSettlementMission.class) {
            Location loc = DefendSettlementMission.extractTarget(aiUnit, path);
            if (!(loc instanceof Colony)) {
                throw new IllegalStateException("European players defend colonies: " + loc);
            }
            Colony colony = (Colony) loc;
            int defenders = getSettlementDefenders(colony);
            value -= 25 * defenders;
            if (colony.hasStockade()) {
                if (defenders > colony.getStockade().getLevel() + 1) {
                    value -= 100 * colony.getStockade().getLevel();
                } else {
                    value -= 20 * colony.getStockade().getLevel();
                }
            }
        }
    }
    return value;
}