private static String invalidColonyReason(AIUnit aiUnit, Colony colony) {
    String reason = invalidTargetReason(colony);
    if (reason != null)
        return reason;
    final Unit unit = aiUnit.getUnit();
    final Player owner = unit.getOwner();
    Player targetPlayer = colony.getOwner();
    switch(owner.getStance(targetPlayer)) {
        case UNCONTACTED:
        case PEACE:
        case ALLIANCE:
            return "bad-stance";
        case WAR:
        case CEASE_FIRE:
            Tension tension = unit.getHomeIndianSettlement().getAlarm(targetPlayer);
            if (tension != null && tension.getLevel().compareTo(Tension.Level.CONTENT) <= 0)
                return "happy";
            break;
    }
    return null;
}