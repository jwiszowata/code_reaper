private void setColor(Element element) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final SetColorMessage message = new SetColorMessage(game, element);
    Nation nation = message.getNation(spec);
    if (nation != null) {
        Color color = message.getColor();
        if (color != null) {
            nation.setColor(color);
            getGUI().refreshPlayersTable();
        } else {
            logger.warning("Invalid color: " + message.toString());
        }
    } else {
        logger.warning("Invalid nation: " + message.toString());
    }
}