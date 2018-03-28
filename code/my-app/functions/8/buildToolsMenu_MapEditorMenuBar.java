private void buildToolsMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.tools");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_T);
    menu.add(getMenuItem(ScaleMapAction.id));
    menu.add(getMenuItem(DetermineHighSeasAction.id));
    add(menu);
}