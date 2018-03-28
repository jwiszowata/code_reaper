public void valueChanged(ListSelectionEvent e) {
    Settlement settlement = this.settlementList.getSelectedValue();
    if (settlement != null) {
        getGUI().setFocus(settlement.getTile());
    }
}