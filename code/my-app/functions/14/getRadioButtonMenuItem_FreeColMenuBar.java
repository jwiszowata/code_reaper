protected JRadioButtonMenuItem getRadioButtonMenuItem(String actionId, ButtonGroup group) {
    JRadioButtonMenuItem rtn = null;
    FreeColAction action = am.getFreeColAction(actionId);
    if (action != null) {
        rtn = new JRadioButtonMenuItem();
        rtn.setAction(action);
        rtn.setOpaque(false);
        rtn.setSelected(((SelectableAction) am.getFreeColAction(actionId)).isSelected());
        group.add(rtn);
    } else {
        logger.finest("Could not create menu item. [" + actionId + "] not found.");
    }
    return rtn;
}