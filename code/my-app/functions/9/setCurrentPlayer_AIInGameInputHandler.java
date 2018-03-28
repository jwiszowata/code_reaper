private void setCurrentPlayer(SetCurrentPlayerMessage message) {
    final Player currentPlayer = message.getPlayer(getGame());
    if (currentPlayer != null && getMyPlayer().getId().equals(currentPlayer.getId())) {
        getAIPlayer().invoke(() -> {
            getAIPlayer().startWorking();
            AIMessage.askEndTurn(getAIPlayer());
        });
    }
}