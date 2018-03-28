private void buildGameMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.game");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_G);
    menu.add(getMenuItem(NewAction.id));
    menu.add(getMenuItem(NewEmptyMapAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(OpenAction.id));
    menu.add(getMenuItem(SaveAction.id));
    menu.add(getMenuItem(StartMapAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(PreferencesAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(ShowMainAction.id));
    menu.add(getMenuItem(QuitAction.id));
    add(menu);
}