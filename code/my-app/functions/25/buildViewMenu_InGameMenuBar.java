private void buildViewMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.view");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_V);
    menu.add(getCheckBoxMenuItem(MapControlsAction.id));
    menu.add(getCheckBoxMenuItem(DisplayGridAction.id));
    menu.add(getCheckBoxMenuItem(DisplayBordersAction.id));
    menu.add(getMenuItem(ToggleViewModeAction.id));
    menu.add(getCheckBoxMenuItem(ChangeWindowedModeAction.id));
    menu.addSeparator();
    ButtonGroup group = new ButtonGroup();
    for (DisplayText type : DisplayText.values()) {
        menu.add(getRadioButtonMenuItem(DisplayTileTextAction.id + type.getKey(), group));
    }
    menu.addSeparator();
    menu.add(getMenuItem(ZoomInAction.id));
    menu.add(getMenuItem(ZoomOutAction.id));
    menu.add(getMenuItem(CenterAction.id));
    menu.add(getMenuItem(TilePopupAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(EuropeAction.id));
    menu.add(getMenuItem(TradeRouteAction.id));
    menu.add(getMenuItem(FindSettlementAction.id));
    add(menu);
}