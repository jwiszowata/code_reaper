public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (null != command)
        switch(command) {
            case ADD:
                Stance stance = (Stance) stanceBox.getSelectedItem();
                NegotiationDialog.this.addStanceTradeItem(stance);
                break;
            case CLEAR:
                NegotiationDialog.this.removeTradeItems(StanceTradeItem.class);
                break;
            default:
                logger.warning("Bad command: " + command);
                break;
        }
}