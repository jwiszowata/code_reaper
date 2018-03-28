private void diplomacy(DiplomacyMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final Game game = getGame();
    final FreeColGameObject our = message.getOurFCGO(game);
    final FreeColGameObject other = message.getOtherFCGO(game);
    final DiplomaticTrade agreement = message.getAgreement();
    StringBuilder sb = new StringBuilder(256);
    sb.append("AI Diplomacy: ").append(agreement);
    switch(agreement.getStatus()) {
        case PROPOSE_TRADE:
            agreement.setStatus(aiPlayer.acceptDiplomaticTrade(agreement));
            sb.append(" -> ").append(agreement);
            logger.fine(sb.toString());
            break;
        default:
            sb.append(" -> ignoring ").append(agreement.getStatus());
            logger.fine(sb.toString());
            return;
    }
    aiPlayer.invoke(() -> {
        AIMessage.askDiplomacy(aiPlayer, our, other, agreement);
    });
}