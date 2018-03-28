public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (OK.equals(command)) {
        getGUI().removeFromCanvas(this);
    } else {
        FreeColGameObject fco = getGame().getFreeColGameObject(command);
        if (fco != null) {
            getGUI().displayObject(fco);
        } else {
            getGUI().showColopediaPanel(command);
        }
    }
}