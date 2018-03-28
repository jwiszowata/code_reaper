private void setNation(Element element) {
    final Game game = getGame();
    final SetNationMessage message = new SetNationMessage(game, element);
    Player player = message.getPlayer(game);
    Nation nation = message.getValue(getSpecification());
    if (player != null && nation != null) {
        player.setNation(nation);
        getGUI().refreshPlayersTable();
    }
}