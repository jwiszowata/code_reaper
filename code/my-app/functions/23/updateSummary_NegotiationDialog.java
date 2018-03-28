private void updateSummary() {
    final Player player = getMyPlayer();
    summary.removeAll();
    summary.add(Utility.localizedTextArea(comment), "center, span 2");
    List<TradeItem> offers = agreement.getItemsGivenBy(player);
    if (!offers.isEmpty()) {
        summary.add(Utility.localizedLabel(this.offer), "span");
        for (TradeItem item : offers) {
            summary.add(getTradeItemButton(item, true), "skip");
        }
    }
    List<TradeItem> demands = agreement.getItemsGivenBy(otherPlayer);
    if (!demands.isEmpty()) {
        if (offers.isEmpty()) {
            summary.add(Utility.localizedLabel(this.demand), "span");
        } else {
            summary.add(new JLabel(exchangeMessage), "newline 20, span");
        }
        for (TradeItem item : demands) {
            summary.add(getTradeItemButton(item, false), "skip");
        }
    }
}