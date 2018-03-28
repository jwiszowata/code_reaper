public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (OK.equals(command)) {
        getGUI().removeFromCanvas(this);
    } else {
        logger.warning("Bad event: " + command);
    }
}