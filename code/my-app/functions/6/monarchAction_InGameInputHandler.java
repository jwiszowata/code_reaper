private void monarchAction(MonarchActionMessage message) {
    final Game game = getGame();
    final StringTemplate template = message.getTemplate();
    final String key = message.getMonarchKey();
    invokeLater(() -> igc().monarch(message.getAction(), template, key));
}