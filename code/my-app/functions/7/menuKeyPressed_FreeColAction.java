public void menuKeyPressed(MenuKeyEvent e) {
    if (e.getKeyCode() == mnemonic) {
        ActionEvent ae = new ActionEvent(e.getSource(), e.getID(), (String) getValue(Action.NAME), e.getModifiers());
        actionPerformed(ae);
        e.consume();
    }
}