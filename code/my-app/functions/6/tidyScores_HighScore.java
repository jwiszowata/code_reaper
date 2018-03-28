private static void tidyScores(List<HighScore> scores) {
    if (scores.size() > NUMBER_OF_HIGH_SCORES) {
        scores = scores.subList(0, NUMBER_OF_HIGH_SCORES - 1);
    }
    scores.sort(descendingScoreComparator);
}