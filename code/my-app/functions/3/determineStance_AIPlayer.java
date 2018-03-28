protected Stance determineStance(Player other) {
    return player.getStance(other).getStanceFromTension(player.getTension(other));
}