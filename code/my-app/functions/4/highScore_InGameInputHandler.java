private void highScore(HighScoreMessage message) {
    final Game game = getGame();
    invokeLater(() -> igc().displayHighScores(message.getKey(), message.getScores()));
}