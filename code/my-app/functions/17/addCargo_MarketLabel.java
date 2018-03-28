public Component addCargo(Component comp, Unit carrier, CargoPanel cargoPanel) {
    MarketLabel label = (MarketLabel) comp;
    Player player = carrier.getOwner();
    if (!player.canTrade(label.getType())) {
        cargoPanel.igc().payArrears(label.getType());
        return null;
    }
    int loadable = carrier.getLoadableAmount(label.getType());
    if (loadable <= 0)
        return null;
    if (loadable > label.getAmount())
        loadable = label.getAmount();
    cargoPanel.igc().buyGoods(label.getType(), loadable, carrier);
    cargoPanel.igc().nextModelMessage();
    cargoPanel.update();
    return comp;
}