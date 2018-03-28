public void showMainPanel(String userMsg) {
    closeMenus();
    frame.removeMenuBar();
    mainPanel = new MainPanel(freeColClient);
    addCentered(mainPanel, JLayeredPane.DEFAULT_LAYER);
    if (userMsg != null)
        gui.showInformationMessage(userMsg);
    mainPanel.requestFocus();
}