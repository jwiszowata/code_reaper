private JMenuItem makeProductionItem(GoodsType type, WorkLocation wl, int amount, UnitLabel unitLabel, boolean claim) {
    StringTemplate t = StringTemplate.template(type.getId() + ".workAs").addAmount("%amount%", amount);
    if (claim) {
        t.addStringTemplate("%claim%", wl.getClaimTemplate());
    } else if (FreeColDebugger.isInDebugMode(FreeColDebugger.DebugMode.MENUS)) {
        t.addStringTemplate("%claim%", wl.getLocationLabel());
    } else {
        t.addName("%claim%", "");
    }
    JMenuItem menuItem = Utility.localizedMenuItem(t, new ImageIcon(gui.getImageLibrary().getSmallIconImage(type)));
    menuItem.setActionCommand(getWorkLabel(wl) + "/" + wl.getId() + "/" + type.getId() + "/" + ((claim) ? "!" : ""));
    menuItem.addActionListener(unitLabel);
    return menuItem;
}