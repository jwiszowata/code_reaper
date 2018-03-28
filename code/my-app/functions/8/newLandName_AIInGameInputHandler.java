private void newLandName(NewLandNameMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final Unit unit = message.getUnit(aiPlayer.getPlayer());
    final String name = message.getNewLandName();
    aiPlayer.invoke(() -> {
        AIMessage.askNewLandName(aiPlayer, unit, name);
    });
}