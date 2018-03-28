protected JCheckBoxMenuItem getCheckBoxMenuItem(String actionId) {
    JCheckBoxMenuItem rtn = null;
    FreeColAction action = am.getFreeColAction(actionId);
    if (action != null) {
        rtn = new JCheckBoxMenuItem();
        rtn.setAction(action);
        rtn.setOpaque(false);
        rtn.setSelected(((SelectableAction) am.getFreeColAction(actionId)).isSelected());
    } else
        logger.finest("Could not create menu item. [" + actionId + "] not found.");
    return rtn;
}