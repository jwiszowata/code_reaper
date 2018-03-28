public int evaluateFor(Player player) {
    final Player victim = getVictim();
    switch(player.getStance(victim)) {
        case ALLIANCE:
            return Integer.MIN_VALUE;
        case WAR:
            return 0;
        default:
            break;
    }
    return (int) Math.round(50.0 / player.getStrengthRatio(victim, false));
}