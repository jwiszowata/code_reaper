private void initializeMissions(LogBuilder lb) {
    final Player player = getPlayer();
    lb.add("\n  Initialize");
    for (IndianSettlement is : player.getIndianSettlementList()) {
        List<Unit> units = is.getAllUnitsList();
        while (units.size() > is.getRequiredDefenders()) {
            Unit u = units.remove(0);
            AIUnit aiu = getAIUnit(u);
            Mission m = getWanderHostileMission(aiu);
            if (m != null)
                lb.add(" ", m);
        }
        for (Unit u : units) {
            AIUnit aiu = getAIUnit(u);
            Mission m = getDefendSettlementMission(aiu, is);
            if (m != null)
                lb.add(" ", m);
        }
    }
}