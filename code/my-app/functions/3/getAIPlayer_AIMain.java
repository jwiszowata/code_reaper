public AIPlayer getAIPlayer(Player player) {
    return getAIObject(player.getId(), AIPlayer.class);
}