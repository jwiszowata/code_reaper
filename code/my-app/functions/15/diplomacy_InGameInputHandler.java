private void diplomacy(DiplomacyMessage message) {
    final Game game = getGame();
    final DiplomaticTrade agreement = message.getAgreement();
    final FreeColGameObject our = message.getOurFCGO(game);
    final FreeColGameObject other = message.getOtherFCGO(game);
    if (our == null) {
        logger.warning("Our FCGO omitted from diplomacy message.");
        return;
    }
    if (other == null) {
        logger.warning("Other FCGO omitted from diplomacy message.");
        return;
    }
    invokeLater(() -> igc().diplomacy(our, other, agreement));
}