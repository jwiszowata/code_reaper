protected void buildColopediaMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.colopedia");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_C);
    for (PanelType type : PanelType.values()) {
        menu.add(getMenuItem(ColopediaAction.id + type.getKey()));
    }
    menu.addSeparator();
    menu.add(getMenuItem(AboutAction.id));
    add(menu);
}