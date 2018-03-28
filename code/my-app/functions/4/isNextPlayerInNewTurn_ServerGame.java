public boolean isNextPlayerInNewTurn() {
    Player nextPlayer = getNextPlayer();
    return players.indexOf(currentPlayer) > players.indexOf(nextPlayer) || currentPlayer == nextPlayer;
}