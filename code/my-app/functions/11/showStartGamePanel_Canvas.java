public void showStartGamePanel(Game game, Player player, boolean singlePlayerMode) {
    if (game == null) {
        logger.warning("StartGamePanel requires game != null.");
    } else if (player == null) {
        logger.warning("StartGamePanel requires player != null.");
    } else {
        closeMenus();
        startGamePanel.initialize(singlePlayerMode);
        showSubPanel(startGamePanel, false);
    }
}