public QuickActionMenu addMenuItems(JComponent comp) {
    if (comp instanceof UnitLabel) {
        createUnitMenu((UnitLabel) comp);
    } else if (comp instanceof GoodsLabel) {
        createGoodsMenu((GoodsLabel) comp);
    } else if (comp instanceof MarketLabel) {
        createMarketMenu((MarketLabel) comp);
    } else if (comp instanceof ASingleTilePanel) {
        createTileMenu((ASingleTilePanel) comp);
    } else if (comp.getParent() instanceof ASingleTilePanel) {
        createTileMenu((ASingleTilePanel) comp.getParent());
    }
    return this;
}