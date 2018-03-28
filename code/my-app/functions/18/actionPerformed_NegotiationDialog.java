public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (null != command)
        switch(command) {
            case ADD:
                Player victim = (Player) victimBox.getSelectedItem();
                if (victim != null) {
                    NegotiationDialog.this.addInciteTradeItem(source, victim);
                }
                break;
            case CLEAR:
                NegotiationDialog.this.removeTradeItems(InciteTradeItem.class);
                break;
            default:
                logger.warning("Bad command: " + command);
                break;
        }
}