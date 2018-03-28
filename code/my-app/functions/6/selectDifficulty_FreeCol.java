public static String selectDifficulty(String arg) {
    String difficulty = find(map(DIFFICULTIES, d -> "model.difficulty." + d), Messages.matchesName(arg));
    if (difficulty != null)
        setDifficulty(difficulty);
    return difficulty;
}