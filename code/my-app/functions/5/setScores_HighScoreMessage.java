public HighScoreMessage setScores(List<HighScore> scores) {
    this.scores.clear();
    this.scores.addAll(scores);
    return this;
}