public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (SHOW.equals(command)) {
        getGUI().showLogFilePanel();
    } else {
        super.actionPerformed(ae);
    }
}