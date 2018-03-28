public boolean clearWorkLocation(WorkLocation wl) {
    for (Unit u : wl.getUnitList()) {
        WorkLocation w = find(wl.getColony().getCurrentWorkLocations(), w2 -> w2 != wl && w2.canAdd(u));
        if (w != null)
            u.setLocation(w);
    }
    return wl.isEmpty();
}