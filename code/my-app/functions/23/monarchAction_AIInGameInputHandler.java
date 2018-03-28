private void monarchAction(MonarchActionMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final MonarchAction action = message.getAction();
    boolean accept;
    switch(action) {
        case RAISE_TAX_WAR:
        case RAISE_TAX_ACT:
            accept = getAIPlayer().acceptTax(message.getTax());
            logger.finest("AI player monarch action " + action + " = " + accept);
            break;
        case MONARCH_MERCENARIES:
        case HESSIAN_MERCENARIES:
            accept = getAIPlayer().acceptMercenaries();
            logger.finest("AI player monarch action " + action + " = " + accept);
            break;
        default:
            logger.finest("AI player ignoring monarch action " + action);
            return;
    }
    aiPlayer.invoke(() -> {
        AIMessage.askMonarchAction(aiPlayer, action, accept);
    });
}