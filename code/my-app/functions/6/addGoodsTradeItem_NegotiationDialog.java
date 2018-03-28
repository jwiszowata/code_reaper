public void addGoodsTradeItem(Player source, Goods goods) {
    final Player player = getMyPlayer();
    Player destination = (source == otherPlayer) ? player : otherPlayer;
    agreement.add(new GoodsTradeItem(getGame(), source, destination, goods));
    updateDialog();
}