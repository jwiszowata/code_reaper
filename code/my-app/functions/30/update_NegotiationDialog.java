public void update(DiplomaticTrade dt) {
    ActionListener[] listeners = this.goodsBox.getActionListeners();
    for (ActionListener al : listeners) {
        this.goodsBox.removeActionListener(al);
    }
    List<Goods> available = new ArrayList<>(allGoods);
    for (Goods goods : dt.getGoodsGivenBy(source)) {
        for (int i = 0; i < available.size(); i++) {
            Goods g = available.get(i);
            if (g.getType() == goods.getType()) {
                if (g.getAmount() <= goods.getAmount()) {
                    available.remove(i);
                } else {
                    g.setAmount(g.getAmount() - goods.getAmount());
                }
                break;
            }
        }
    }
    this.goodsBox.removeAllItems();
    for (Goods g : available) goodsBox.addItem(g);
    boolean enable = !available.isEmpty();
    this.label.setEnabled(enable);
    this.clearButton.setEnabled(!enable);
    this.addButton.setEnabled(enable);
    this.goodsBox.setEnabled(enable);
    for (ActionListener al : listeners) {
        this.goodsBox.addActionListener(al);
    }
}