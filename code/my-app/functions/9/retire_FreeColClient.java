public void retire() {
    if (gui.confirm("retireDialog.areYouSure.text", "ok", "cancel")) {
        final Game game = getGame();
        final Player player = getMyPlayer();
        player.changePlayerType(Player.PlayerType.RETIRED);
        getInGameController().displayHighScores(null);
        askServer().retire(game);
    }
}