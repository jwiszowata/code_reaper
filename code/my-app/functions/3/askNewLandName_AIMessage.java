public static boolean askNewLandName(AIPlayer aiPlayer, Unit unit, String name) {
    return aiPlayer.askServer().newLandName(unit, name);
}