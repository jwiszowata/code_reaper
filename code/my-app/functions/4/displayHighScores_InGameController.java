public boolean displayHighScores(Boolean high) {
    final Game game = getGame();
    return askServer().getHighScores(game, (high == null) ? null : (high) ? "highscores.yes" : "highscores.no");
}