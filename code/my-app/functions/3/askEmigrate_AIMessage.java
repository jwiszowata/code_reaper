public static boolean askEmigrate(AIPlayer aiPlayer, int slot) {
    return aiPlayer.askServer().emigrate(aiPlayer.getGame(), slot);
}