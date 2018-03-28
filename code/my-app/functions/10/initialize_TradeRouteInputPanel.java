public void initialize(TradeRouteStop newStop) {
    removeAll();
    if (newStop != null) {
        for (GoodsType goodsType : newStop.getCargo()) {
            add(new CargoLabel(goodsType));
        }
    }
    revalidate();
    repaint();
}