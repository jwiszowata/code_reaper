private void addPayArrears(final GoodsType goodsType) {
    final InGameController igc = freeColClient.getInGameController();
    JMenuItem menuItem = Utility.localizedMenuItem("payArrears");
    menuItem.addActionListener((ActionEvent ae) -> {
        igc.payArrears(goodsType);
        if (parentPanel instanceof CargoPanel) {
            CargoPanel cargoPanel = (CargoPanel) parentPanel;
            cargoPanel.initialize();
        }
        parentPanel.revalidate();
    });
    this.add(menuItem);
}