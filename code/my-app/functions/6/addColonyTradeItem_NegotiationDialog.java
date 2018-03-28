public void addColonyTradeItem(Player source, Colony colony) {
    final Player player = getMyPlayer();
    Player destination = (source == otherPlayer) ? player : otherPlayer;
    agreement.add(new ColonyTradeItem(getGame(), source, destination, colony));
    updateDialog();
}