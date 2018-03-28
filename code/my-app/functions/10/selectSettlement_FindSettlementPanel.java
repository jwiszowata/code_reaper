private void selectSettlement() {
    Settlement settlement = this.settlementList.getSelectedValue();
    if (settlement instanceof Colony && settlement.getOwner() == getMyPlayer()) {
        getGUI().removeFromCanvas(FindSettlementPanel.this);
        getGUI().showColonyPanel((Colony) settlement, null);
    } else if (settlement instanceof IndianSettlement) {
        getGUI().removeFromCanvas(FindSettlementPanel.this);
        getGUI().showIndianSettlementPanel((IndianSettlement) settlement);
    }
}