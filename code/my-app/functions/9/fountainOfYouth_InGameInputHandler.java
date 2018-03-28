private void fountainOfYouth(FountainOfYouthMessage message) {
    final Game game = getGame();
    final int n = message.getMigrants();
    if (n <= 0) {
        logger.warning("Invalid migrants attribute: " + n);
        return;
    }
    invokeLater(() -> igc().fountainOfYouth(n));
}