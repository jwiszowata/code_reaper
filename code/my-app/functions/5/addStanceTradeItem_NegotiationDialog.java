public void addStanceTradeItem(Stance stance) {
    final Player player = getMyPlayer();
    agreement.add(new StanceTradeItem(getGame(), otherPlayer, player, stance));
    updateDialog();
}