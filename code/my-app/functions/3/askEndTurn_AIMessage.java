public static boolean askEndTurn(AIPlayer aiPlayer) {
    return aiPlayer.askServer().endTurn(aiPlayer.getGame());
}