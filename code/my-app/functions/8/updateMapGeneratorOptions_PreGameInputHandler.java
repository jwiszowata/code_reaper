private void updateMapGeneratorOptions(Element element) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final UpdateMapGeneratorOptionsMessage message = new UpdateMapGeneratorOptionsMessage(game, element);
    if (!spec.mergeMapGeneratorOptions(message.getMapGeneratorOptions(), "client")) {
        logger.warning("Map generator option update failed");
    }
}