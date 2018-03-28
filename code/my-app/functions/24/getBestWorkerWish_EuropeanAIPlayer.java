public WorkerWish getBestWorkerWish(AIUnit aiUnit, UnitType unitType) {
    List<WorkerWish> wishes = workerWishes.get(unitType);
    if (wishes == null)
        return null;
    final Unit carrier = aiUnit.getUnit();
    WorkerWish carried = null;
    WorkerWish other = null;
    double bestCarriedValue = -1.0, bestOtherValue = -1.0;
    for (WorkerWish w : wishes) {
        int turns = carrier.getTurnsToReach(w.getDestination());
        if (turns < Unit.MANY_TURNS) {
            if (bestCarriedValue < (double) w.getValue() / turns) {
                bestCarriedValue = (double) w.getValue() / turns;
                carried = w;
            }
        } else {
            if (bestOtherValue < w.getValue()) {
                bestOtherValue = w.getValue();
                other = w;
            }
        }
    }
    return (carried != null) ? carried : (other != null) ? other : null;
}