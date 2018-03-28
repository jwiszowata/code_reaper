public int checkBuildQueueIntegrity(boolean fix) {
    int result = 1;
    List<BuildableType> buildables = buildQueue.getValues();
    List<BuildableType> assumeBuilt = new ArrayList<>();
    for (int i = 0; i < buildables.size(); i++) {
        BuildableType bt = buildables.get(i);
        NoBuildReason reason = getNoBuildReason(bt, assumeBuilt);
        if (reason == NoBuildReason.NONE) {
            assumeBuilt.add(bt);
        } else if (fix) {
            buildQueue.remove(i);
            result = Math.min(result, 0);
        } else {
            result = -1;
        }
    }
    List<UnitType> unitTypes = populationQueue.getValues();
    assumeBuilt.clear();
    for (int i = 0; i < unitTypes.size(); i++) {
        UnitType ut = unitTypes.get(i);
        NoBuildReason reason = getNoBuildReason(ut, assumeBuilt);
        if (reason == NoBuildReason.NONE) {
            assumeBuilt.add(ut);
        } else if (fix) {
            populationQueue.remove(i);
            result = Math.min(result, 0);
        } else {
            result = -1;
        }
    }
    return result;
}