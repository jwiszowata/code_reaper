private void buildViewMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.view");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_V);
    menu.add(getCheckBoxMenuItem(MapControlsAction.id));
    menu.add(getCheckBoxMenuItem(DisplayGridAction.id));
    menu.add(getCheckBoxMenuItem(ChangeWindowedModeAction.id));
    menu.addSeparator();
    ButtonGroup tileTextGroup = new ButtonGroup();
    for (DisplayText type : DisplayText.values()) {
        menu.add(getRadioButtonMenuItem(DisplayTileTextAction.id + type.getKey(), tileTextGroup));
    }
    menu.addSeparator();
    menu.add(getMenuItem(ZoomInAction.id));
    menu.add(getMenuItem(ZoomOutAction.id));
    add(menu);
}