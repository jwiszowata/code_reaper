private void buildOrdersMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.orders");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_O);
    menu.add(getMenuItem(SentryAction.id));
    menu.add(getMenuItem(FortifyAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(GotoAction.id));
    menu.add(getMenuItem(GotoTileAction.id));
    menu.add(getMenuItem(ExecuteGotoOrdersAction.id));
    menu.add(getMenuItem(AssignTradeRouteAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(BuildColonyAction.id));
    for (TileImprovementType type : freeColClient.getGame().getSpecification().getTileImprovementTypeList()) {
        if (!type.isNatural()) {
            menu.add(getMenuItem(type.getSuffix() + "Action"));
        }
    }
    menu.addSeparator();
    menu.add(getMenuItem(LoadAction.id));
    menu.add(getMenuItem(UnloadAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(WaitAction.id));
    menu.add(getMenuItem(SkipUnitAction.id));
    menu.add(getMenuItem(ChangeAction.id));
    menu.addSeparator();
    menu.add(getMenuItem(ClearOrdersAction.id));
    menu.add(getMenuItem(RenameAction.id));
    menu.add(getMenuItem(DisbandUnitAction.id));
    add(menu);
}