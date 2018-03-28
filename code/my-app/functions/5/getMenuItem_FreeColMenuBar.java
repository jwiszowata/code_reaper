protected JMenuItem getMenuItem(String actionId, ActionListener actionListener) {
    JMenuItem rtn = getMenuItem(actionId);
    rtn.addActionListener(actionListener);
    return rtn;
}