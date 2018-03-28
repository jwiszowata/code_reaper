private void setNationType(Element element) {
    final Game game = getGame();
    final SetNationTypeMessage message = new SetNationTypeMessage(game, element);
    Player player = message.getPlayer(game);
    NationType nationType = message.getValue(getSpecification());
    if (player != null && nationType != null) {
        player.changeNationType(nationType);
        getGUI().refreshPlayersTable();
    }
}