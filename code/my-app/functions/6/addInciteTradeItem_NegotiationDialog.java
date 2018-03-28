public void addInciteTradeItem(Player source, Player victim) {
    final Player player = getMyPlayer();
    Player destination = (source == otherPlayer) ? player : otherPlayer;
    agreement.add(new InciteTradeItem(getGame(), source, destination, victim));
    updateDialog();
}