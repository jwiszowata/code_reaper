private void buildGameMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.game");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_G);
    menu.add(getMenuItem(NewAction.id));
    menu.add(getMenuItem(OpenAction.id));
    menu.add(getMenuItem(SaveAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(PreferencesAction.id));
    menu.add(getMenuItem(ReconnectAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(ChatAction.id));
    menu.add(getMenuItem(DeclareIndependenceAction.id));
    menu.add(getMenuItem(EndTurnAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(ShowMainAction.id));
    menu.add(getMenuItem(ReportHighScoresAction.id));
    menu.add(getMenuItem(RetireAction.id));
    menu.add(getMenuItem(SaveAndQuitAction.id));
    menu.add(getMenuItem(QuitAction.id));
    add(menu);
}