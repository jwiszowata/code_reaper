private void spySettlement(SpySettlementMessage message) {
    final Game game = getGame();
    final Tile spyTile = message.getSpyTile();
    invokeLater(() -> igc().spyColony(spyTile));
}