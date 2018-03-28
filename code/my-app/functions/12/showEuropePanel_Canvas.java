public void showEuropePanel() {
    if (freeColClient.getGame() == null)
        return;
    EuropePanel panel = getExistingFreeColPanel(EuropePanel.class);
    if (panel == null) {
        panel = new EuropePanel(freeColClient, (getHeight() > 780));
        panel.addClosingCallback(() -> {
            removeEuropeanSubpanels();
        });
        showSubPanel(panel, true);
    }
}