public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (command == null)
        return;
    switch(command) {
        case OK:
            if (!verifyNewTradeRoute())
                return;
            super.actionPerformed(ae);
            break;
        case CANCEL:
            cancelTradeRoute();
            break;
        default:
            super.actionPerformed(ae);
            break;
    }
}