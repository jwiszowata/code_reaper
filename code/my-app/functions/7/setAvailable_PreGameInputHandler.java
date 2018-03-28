private void setAvailable(Element element) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final SetAvailableMessage message = new SetAvailableMessage(game, element);
    game.getNationOptions().setNationState(message.getNation(spec), message.getNationState());
    getGUI().refreshPlayersTable();
}