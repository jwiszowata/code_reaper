public boolean displayModelMessages(final boolean allMessages, final boolean endOfTurn) {
    final Player player = getMyPlayer();
    final Turn thisTurn = getGame().getTurn();
    final ArrayList<ModelMessage> messages = new ArrayList<>();
    for (ModelMessage m : ((allMessages) ? player.getModelMessages() : player.getNewModelMessages())) {
        if (shouldAllowMessage(m) && !continueIgnoreMessage(m.getIgnoredMessageKey(), thisTurn)) {
            messages.add(m);
        }
        m.setBeenDisplayed(true);
    }
    reapIgnoredMessages(thisTurn);
    if (!messages.isEmpty()) {
        Runnable uiTask;
        if (endOfTurn) {
            turnReportMessages.addAll(messages);
            uiTask = () -> {
                displayTurnReportMessages();
            };
        } else {
            uiTask = () -> {
                getGUI().showModelMessages(messages);
            };
        }
        getGUI().invokeNowOrWait(uiTask);
    }
    return !messages.isEmpty();
}