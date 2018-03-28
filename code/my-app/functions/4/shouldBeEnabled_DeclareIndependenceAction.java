protected boolean shouldBeEnabled() {
    Player p = freeColClient.getMyPlayer();
    return super.shouldBeEnabled() && p != null && p.getPlayerType() == PlayerType.COLONIAL;
}