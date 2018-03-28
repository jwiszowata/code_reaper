private void update(Element element) {
    final Game game = getGame();
    final UpdateMessage message = new UpdateMessage(game, element);
    for (FreeColGameObject fcgo : message.getObjects()) {
        if (fcgo instanceof Game) {
            getFreeColClient().addSpecificationActions(((Game) fcgo).getSpecification());
        } else {
            logger.warning("Game node expected: " + fcgo.getId());
        }
    }
}