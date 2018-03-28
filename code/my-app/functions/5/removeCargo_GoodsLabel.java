public void removeCargo(Component comp, CargoPanel cargoPanel) {
    Goods g = ((GoodsLabel) comp).getGoods();
    cargoPanel.igc().unloadCargo(g, false);
    cargoPanel.update();
}