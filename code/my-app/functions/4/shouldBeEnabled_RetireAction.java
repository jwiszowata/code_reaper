protected boolean shouldBeEnabled() {
    Player player = freeColClient.getMyPlayer();
    return super.shouldBeEnabled() && player != null && player.getPlayerType() != Player.PlayerType.RETIRED;
}