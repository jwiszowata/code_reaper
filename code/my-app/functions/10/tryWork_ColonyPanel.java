private boolean tryWork(Unit unit, WorkLocation wl) {
    GoodsType workType = wl.getWorkFor(unit);
    igc().work(unit, wl);
    if (unit.getLocation() != wl)
        return false;
    if (workType != null && workType != unit.getWorkType()) {
        igc().changeWorkType(unit, workType);
    }
    return true;
}