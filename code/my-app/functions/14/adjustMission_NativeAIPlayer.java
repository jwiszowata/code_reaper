public int adjustMission(AIUnit aiUnit, PathNode path, Class type, int value) {
    if (type == DefendSettlementMission.class) {
        Settlement settlement = (Settlement) DefendSettlementMission.extractTarget(aiUnit, path);
        value -= 75 * getSettlementDefenders(settlement);
    } else if (type == UnitSeekAndDestroyMission.class) {
        Location target = UnitSeekAndDestroyMission.extractTarget(aiUnit, path);
        Player targetPlayer = (target instanceof Ownable) ? ((Ownable) target).getOwner() : null;
        IndianSettlement is = aiUnit.getUnit().getHomeIndianSettlement();
        if (targetPlayer != null && is != null && is.getAlarm(targetPlayer) != null) {
            value += is.getAlarm(targetPlayer).getValue() - Tension.Level.DISPLEASED.getLimit();
        }
    }
    return value;
}