public static Unit getBestWorker(WorkLocation wl, GoodsType goodsType, List<Unit> workers) {
    if (workers == null || workers.isEmpty())
        return null;
    final Colony colony = wl.getColony();
    final GoodsType outputType = (goodsType.isStoredAs()) ? goodsType.getStoredAs() : goodsType;
    if (workers.size() == 1) {
        Unit u = workers.get(0);
        if (!wl.canAdd(u))
            return null;
        Location oldLoc = u.getLocation();
        GoodsType oldWork = u.getWorkType();
        u.setLocation(wl);
        u.changeWorkType(goodsType);
        int production = wl.getProductionOf(u, goodsType);
        u.setLocation(oldLoc);
        u.changeWorkType(oldWork);
        return (production > 0) ? u : null;
    }
    List<Unit> todo = new ArrayList<>(workers);
    List<Unit> best = new ArrayList<>();
    int bestValue = colony.getAdjustedNetProductionOf(outputType);
    Unit special = null;
    best.clear();
    for (Unit u : transform(todo, u2 -> wl.canAdd(u2))) {
        Location oldLoc = u.getLocation();
        GoodsType oldWork = u.getWorkType();
        u.setLocation(wl);
        u.changeWorkType(goodsType);
        int value = colony.getAdjustedNetProductionOf(outputType);
        if (value > bestValue) {
            bestValue = value;
            best.clear();
            best.add(u);
            if (u.getType().getExpertProduction() == goodsType) {
                special = u;
            }
        } else if (value == bestValue && !best.isEmpty()) {
            best.add(u);
            if (u.getType().getExpertProduction() == goodsType) {
                special = u;
            }
        }
        u.setLocation(oldLoc);
        u.changeWorkType(oldWork);
    }
    switch(best.size()) {
        case 0:
            return null;
        case 1:
            return best.get(0);
        default:
            todo.clear();
            todo.addAll(best);
            break;
    }
    if (special != null)
        return special;
    Specification spec = colony.getSpecification();
    UnitType expert = spec.getExpertForProducing(goodsType);
    best.clear();
    bestValue = Integer.MIN_VALUE;
    for (Unit u : todo) {
        boolean relevant = u.getWorkType() == goodsType;
        int score = (relevant) ? u.getExperience() : -u.getExperience();
        if (expert != null && u.getUnitChange(UnitChangeType.EXPERIENCE, expert) != null) {
            score += 10000;
        } else if (expert != null && u.getUnitChange(UnitChangeType.EXPERIENCE, expert) != null) {
            score -= 10000;
        }
        if (score > bestValue) {
            best.clear();
            best.add(u);
            bestValue = score;
        } else if (score == bestValue) {
            best.add(u);
        }
    }
    switch(best.size()) {
        case 0:
            break;
        case 1:
            return best.get(0);
        default:
            todo.clear();
            todo.addAll(best);
            break;
    }
    int worstSkill = Integer.MAX_VALUE;
    special = null;
    for (Unit u : todo) {
        if (u.getType().getSkill() < worstSkill) {
            special = u;
            worstSkill = u.getType().getSkill();
        }
    }
    return special;
}