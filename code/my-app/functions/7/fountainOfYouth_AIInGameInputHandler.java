private void fountainOfYouth(FountainOfYouthMessage message) {
    final AIPlayer aiPlayer = getAIPlayer();
    final int n = message.getMigrants();
    getAIPlayer().invoke(() -> {
        for (int i = 0; i < n; i++) AIMessage.askEmigrate(aiPlayer, 0);
    });
}