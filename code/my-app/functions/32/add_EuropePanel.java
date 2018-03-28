public Component add(Component comp, boolean editState) {
    if (editState) {
        if (!(comp instanceof GoodsLabel)) {
            logger.warning("Invalid component: " + comp);
            return null;
        }
        Goods goods = ((GoodsLabel) comp).getGoods();
        if (getMyPlayer().canTrade(goods.getType())) {
            igc().sellGoods(goods);
        } else {
            BoycottAction act = getGUI().getBoycottChoice(goods, europe);
            if (act != null) {
                switch(act) {
                    case BOYCOTT_PAY_ARREARS:
                        igc().payArrears(goods.getType());
                        break;
                    case BOYCOTT_DUMP_CARGO:
                        igc().unloadCargo(goods, true);
                        break;
                    default:
                        logger.warning("showBoycottedGoodsDialog fail: " + act);
                        break;
                }
            }
        }
        cargoPanel.revalidate();
        revalidate();
        igc().nextModelMessage();
    }
    EuropePanel.this.refresh();
    return comp;
}