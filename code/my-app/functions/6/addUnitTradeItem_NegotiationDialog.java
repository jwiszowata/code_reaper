public void addUnitTradeItem(Player source, Unit unit) {
    final Player player = getMyPlayer();
    Player destination = (source == otherPlayer) ? player : otherPlayer;
    agreement.add(new UnitTradeItem(getGame(), source, destination, unit));
    updateDialog();
}