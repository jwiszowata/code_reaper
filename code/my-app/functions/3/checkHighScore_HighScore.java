public static boolean checkHighScore(int score, List<HighScore> scores) {
    return score >= 0 && (scores.size() < NUMBER_OF_HIGH_SCORES || score > scores.get(scores.size() - 1).getScore());
}