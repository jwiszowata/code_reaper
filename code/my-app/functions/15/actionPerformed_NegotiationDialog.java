public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (null != command)
        switch(command) {
            case ADD:
                NegotiationDialog.this.addUnitTradeItem(source, (Unit) unitBox.getSelectedItem());
                break;
            case CLEAR:
                NegotiationDialog.this.removeTradeItems(UnitTradeItem.class);
                break;
            default:
                logger.warning("Bad command: " + command);
                break;
        }
}