public void showPurchasePanel() {
    PurchasePanel panel = getExistingFreeColPanel(PurchasePanel.class);
    if (panel == null) {
        showFreeColPanel(new PurchasePanel(freeColClient), null, false);
    }
}