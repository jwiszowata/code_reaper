private void chooseFoundingFather(ChooseFoundingFatherMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final List<FoundingFather> fathers = message.getFathers(getGame());
    final FoundingFather ff = aiPlayer.selectFoundingFather(fathers);
    if (ff != null) {
        logger.finest(aiPlayer.getId() + " chose founding father: " + ff);
        aiPlayer.invoke(() -> {
            AIMessage.askChooseFoundingFather(aiPlayer, fathers, ff);
        });
    }
}