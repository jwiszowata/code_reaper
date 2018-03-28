public void showIndianSettlementPanel(IndianSettlement is) {
    IndianSettlementPanel panel = new IndianSettlementPanel(freeColClient, is);
    showFreeColPanel(panel, is.getTile(), true);
}