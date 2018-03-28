public void addGoldTradeItem(Player source, int amount) {
    final Player player = getMyPlayer();
    Player destination = (source == otherPlayer) ? player : otherPlayer;
    agreement.add(new GoldTradeItem(getGame(), source, destination, amount));
    updateDialog();
}