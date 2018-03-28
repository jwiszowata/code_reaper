protected JMenuItem getMenuItem(String actionId) {
    JMenuItem rtn = null;
    FreeColAction action = am.getFreeColAction(actionId);
    if (action != null) {
        rtn = new JMenuItem();
        rtn.setAction(action);
        rtn.setOpaque(false);
        if (action.getMnemonic() != null) {
            rtn.addMenuKeyListener(action.getMenuKeyListener());
        }
    } else {
        logger.finest("Could not create menu item. [" + actionId + "] not found.");
    }
    return rtn;
}