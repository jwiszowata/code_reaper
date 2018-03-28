private static String invalidColonyReason(AIUnit aiUnit, Colony colony) {
    String reason = invalidTargetReason(colony);
    if (reason != null)
        return reason;
    final Unit unit = aiUnit.getUnit();
    final Player owner = unit.getOwner();
    Player targetPlayer = colony.getOwner();
    switch(owner.getStance(targetPlayer)) {
        case UNCONTACTED:
        case WAR:
        case CEASE_FIRE:
            return "bad-stance";
        case PEACE:
        case ALLIANCE:
            Tension tension = unit.getHomeIndianSettlement().getAlarm(targetPlayer);
            if (tension != null && tension.getLevel().compareTo(Tension.Level.HAPPY) > 0)
                return "unhappy";
    }
    return null;
}