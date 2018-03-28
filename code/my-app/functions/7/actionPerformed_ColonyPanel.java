public void actionPerformed(ActionEvent ae) {
    if (OK.equals(ae.getActionCommand())) {
        closeColonyPanel();
    } else {
        super.actionPerformed(ae);
    }
}