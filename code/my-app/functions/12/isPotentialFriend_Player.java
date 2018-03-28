public boolean isPotentialFriend(Player player) {
    if (player.getREFPlayer() != this) {
        switch(getStance(player)) {
            case WAR:
            case CEASE_FIRE:
                return true;
            default:
                break;
        }
    }
    return false;
}