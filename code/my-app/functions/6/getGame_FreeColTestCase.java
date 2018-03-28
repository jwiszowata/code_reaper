public static Game getGame() {
    if (game == null) {
        game = getStandardGame();
    }
    return game;
}