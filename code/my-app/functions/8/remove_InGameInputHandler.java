private void remove(RemoveMessage message) {
    final Game game = getGame();
    final FreeColGameObject divert = message.getDivertObject(game);
    final List<FreeColGameObject> objects = message.getRemovals(game);
    if (!objects.isEmpty()) {
        invokeLater(() -> igc().remove(objects, divert));
    }
}