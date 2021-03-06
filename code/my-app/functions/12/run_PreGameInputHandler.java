public void run() {
    Game game;
    for (; ; ) {
        game = getGame();
        if (game != null && game.getMap() != null)
            break;
        Utils.delay(200, "Starting a game has been interupted.");
    }
    SwingUtilities.invokeLater(() -> {
        pgc().startGame();
    });
}