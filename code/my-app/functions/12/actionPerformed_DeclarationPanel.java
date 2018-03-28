public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (ANIMATION_STOPPED.equals(command)) {
        Timer t = new Timer(FINISH_DELAY, (x) -> {
            getGUI().removeFromCanvas(DeclarationPanel.this);
        });
        t.setRepeats(false);
        t.start();
    } else {
        super.actionPerformed(ae);
    }
}