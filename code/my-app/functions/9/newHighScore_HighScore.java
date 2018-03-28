public static boolean newHighScore(Player player) {
    List<HighScore> scores = loadHighScores();
    if (!checkHighScore(player.getScore(), scores))
        return false;
    HighScore hs = new HighScore(player);
    scores.add(hs);
    tidyScores(scores);
    return saveHighScores(scores);
}