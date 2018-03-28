public Component addCargo(Component comp, Unit carrier, CargoPanel cargoPanel) {
    Goods goods = ((GoodsLabel) comp).getGoods();
    int loadable = carrier.getLoadableAmount(goods.getType());
    if (loadable <= 0)
        return null;
    if (loadable > goods.getAmount())
        loadable = goods.getAmount();
    Goods toAdd = new Goods(goods.getGame(), goods.getLocation(), goods.getType(), loadable);
    goods.setAmount(goods.getAmount() - loadable);
    cargoPanel.igc().loadCargo(toAdd, carrier);
    cargoPanel.update();
    return comp;
}