public int evaluateFor(Player player) {
    final Stance stance = getStance();
    final double ratio = player.getStrengthRatio(getOther(player), false);
    int value = (int) Math.round(100 * ratio);
    switch(stance) {
        case WAR:
            if (ratio < 0.33)
                return Integer.MIN_VALUE;
            if (ratio < 0.5)
                value = -value;
            break;
        case PEACE:
        case CEASE_FIRE:
        case ALLIANCE:
            if (ratio > 0.66)
                return Integer.MIN_VALUE;
            if (ratio > 0.5)
                value = -value;
            else if (ratio < 0.33)
                value = 1000;
            break;
        case UNCONTACTED:
        default:
            value = Integer.MIN_VALUE;
            break;
    }
    return value;
}