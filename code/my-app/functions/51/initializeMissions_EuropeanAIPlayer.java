private void initializeMissions(LogBuilder lb) {
    final AIMain aiMain = getAIMain();
    List<AIUnit> aiUnits = getAIUnits();
    lb.add("\n  Initialize ");
    final Map map = getGame().getMap();
    final int maxRange = map.getWidth() + map.getHeight();
    Location target;
    Mission m;
    TransportMission tm;
    for (AIUnit aiCarrier : aiUnits) {
        if (aiCarrier.hasMission())
            continue;
        Unit carrier = aiCarrier.getUnit();
        if (!carrier.isNaval())
            continue;
        target = null;
        for (Unit u : carrier.getUnitList()) {
            AIUnit aiu = aiMain.getAIUnit(u);
            for (int range = buildingRange; range < maxRange; range += buildingRange) {
                target = BuildColonyMission.findTarget(aiu, range, false);
                if (target != null)
                    break;
            }
            if (target == null) {
                throw new RuntimeException("Initial colony fail!");
            }
            if ((m = getBuildColonyMission(aiu, target)) != null) {
                lb.add(m, ", ");
            }
        }
        tm = (TransportMission) getTransportMission(aiCarrier);
        if (tm != null) {
            lb.add(tm);
            for (Unit u : carrier.getUnitList()) {
                AIUnit aiu = getAIMain().getAIUnit(u);
                if (aiu == null)
                    continue;
                tm.queueTransportable(aiu, false, lb);
            }
        }
    }
    lb.mark();
    for (AIUnit aiu : aiUnits) {
        if (aiu.hasMission())
            continue;
        if ((m = getSimpleMission(aiu)) != null)
            lb.add(m, ", ");
    }
    if (lb.grew("\n  Backup: "))
        lb.shrink(", ");
}