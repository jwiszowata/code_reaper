public void update() {
    final GoodsType type = getType();
    final Player player = market.getOwner();
    String toolTipText = Messages.getName(type);
    if (player == null || player.canTrade(type)) {
        setEnabled(true);
    } else {
        toolTipText = Messages.message(type.getLabel());
        setEnabled(false);
    }
    if (FreeColDebugger.isInDebugMode(DebugMode.MENUS)) {
        toolTipText += " " + market.getAmountInMarket(type);
    }
    setToolTipText(toolTipText);
    setText(market.getPaidForSale(type) + "/" + market.getCostToBuy(type));
}