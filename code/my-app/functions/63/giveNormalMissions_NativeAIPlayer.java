private void giveNormalMissions(LogBuilder lb) {
    final Player player = getPlayer();
    List<AIUnit> aiUnits = getAIUnits();
    lb.mark();
    List<AIUnit> done = new ArrayList<>();
    reasons.clear();
    for (AIUnit aiUnit : aiUnits) {
        final Unit unit = aiUnit.getUnit();
        Mission m = aiUnit.getMission();
        if (!unit.isInitialized() || unit.isDisposed()) {
            reasons.put(unit, "Invalid");
        } else if (m != null && m.isValid() && !m.isOneTime()) {
            reasons.put(unit, "Valid");
        } else {
            continue;
        }
        done.add(aiUnit);
    }
    aiUnits.removeAll(done);
    done.clear();
    for (AIUnit aiUnit : aiUnits) {
        final Unit unit = aiUnit.getUnit();
        final Settlement settlement = unit.getSettlement();
        final IndianSettlement is = unit.getHomeIndianSettlement();
        Mission m = aiUnit.getMission();
        if (settlement != null && settlement.getUnitCount() + settlement.getTile().getUnitCount() <= 1) {
            if (!(m instanceof DefendSettlementMission) || m.getTarget() != settlement) {
                m = getDefendSettlementMission(aiUnit, settlement);
                if (m == null)
                    continue;
                lb.add(m, ", ");
            }
            reasons.put(unit, "Defend-" + settlement.getName());
        } else if (is != null && is.canImproveUnitMilitaryRole(unit) != null) {
            if (!(m instanceof DefendSettlementMission) || m.getTarget() != is) {
                m = getDefendSettlementMission(aiUnit, is);
                if (m == null)
                    continue;
                lb.add(m, ", ");
            }
            reasons.put(unit, "Equip-" + is.getName());
        } else {
            if (!(m instanceof UnitWanderHostileMission)) {
                m = getWanderHostileMission(aiUnit);
                if (m == null)
                    continue;
                lb.add(m, ", ");
            }
            reasons.put(unit, "Patrol");
        }
        done.add(aiUnit);
    }
    aiUnits.removeAll(done);
    done.clear();
    if (lb.grew("\n  Mission changes: "))
        lb.shrink(", ");
    if (!aiUnits.isEmpty()) {
        lb.add("\n  Free Land Units:");
        for (AIUnit aiu : aiUnits) lb.add(" ", aiu.getUnit());
    }
    lb.add("\n  Missions(settlements=", player.getSettlementCount(), ")");
    logMissions(reasons, lb);
}