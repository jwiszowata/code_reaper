public boolean getHighScores(Game game, String key) {
    return ask(game, new HighScoreMessage(key));
}