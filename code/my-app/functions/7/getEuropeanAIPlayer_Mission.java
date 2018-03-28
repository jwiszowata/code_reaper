protected final EuropeanAIPlayer getEuropeanAIPlayer() {
    Player player = getUnit().getOwner();
    if (!player.isEuropean()) {
        throw new IllegalArgumentException("Not a European player: " + player);
    }
    return (EuropeanAIPlayer) getAIMain().getAIPlayer(player);
}