public boolean completeWish(Unit unit, LogBuilder lb) {
    boolean ret = false;
    int i = 0;
    while (i < wishes.size()) {
        if (wishes.get(i) instanceof WorkerWish) {
            WorkerWish ww = (WorkerWish) wishes.get(i);
            if (ww.satisfiedBy(unit) && completeWish(ww, unit.toShortString(), lb)) {
                ret = true;
                continue;
            }
        }
        i++;
    }
    return ret;
}