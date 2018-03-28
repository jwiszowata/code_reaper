public void initialize() {
    removeAll();
    final Market market = getMyPlayer().getMarket();
    ImageLibrary lib = getImageLibrary();
    for (GoodsType goodsType : getSpecification().getStorableGoodsTypeList()) {
        MarketLabel label = new MarketLabel(lib, goodsType, market);
        label.setTransferHandler(defaultTransferHandler);
        label.addMouseListener(pressListener);
        MarketData md = market.getMarketData(goodsType);
        if (md != null)
            md.addPropertyChangeListener(label);
        add(label);
    }
}