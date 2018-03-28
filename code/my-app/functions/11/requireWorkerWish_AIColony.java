public void requireWorkerWish(UnitType type, boolean expertNeeded, int value, LogBuilder lb) {
    WorkerWish ww = (WorkerWish) find(wishes, w -> w instanceof WorkerWish && ((WorkerWish) w).getUnitType() == type);
    if (ww != null) {
        ww.update(type, expertNeeded, ww.getValue() + 1);
        lb.add(", update ", ww);
    } else {
        ww = new WorkerWish(getAIMain(), colony, value, type, expertNeeded);
        wishes.add(ww);
        lb.add(", add ", ww);
    }
}