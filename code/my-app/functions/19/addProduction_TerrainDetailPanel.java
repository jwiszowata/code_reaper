private void addProduction(JPanel panel, Stream<AbstractGoods> production) {
    List<AbstractGoods> pro = transform(production, AbstractGoods::isPositive);
    String tag = null;
    switch(pro.size()) {
        case 0:
            panel.add(new JLabel(), "wrap");
            break;
        case 1:
            tag = "span";
            break;
        default:
            tag = "span, split " + pro.size();
            break;
    }
    for (AbstractGoods ag : pro) {
        panel.add(getGoodsButton(ag.getType(), ag.getAmount()), tag);
        tag = null;
    }
}