private void scoutSpeakToChief(ScoutSpeakToChiefMessage message) {
    final Game game = getGame();
    final Unit unit = message.getUnit(game);
    final IndianSettlement is = message.getSettlement(game);
    final String result = message.getResult();
    invokeLater(() -> igc().scoutSpeakToChief(unit, is, result));
}