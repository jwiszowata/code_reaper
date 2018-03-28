public boolean isPotentialEnemy(Player player) {
    if (!hasAbility(Ability.IGNORE_EUROPEAN_WARS) && player.getREFPlayer() != this) {
        switch(getStance(player)) {
            case PEACE:
            case CEASE_FIRE:
                return true;
            default:
                break;
        }
    }
    return false;
}