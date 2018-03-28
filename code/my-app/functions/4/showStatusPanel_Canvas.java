public void showStatusPanel(String message) {
    statusPanel.setStatusMessage(message);
    addCentered(statusPanel, JLayeredPane.POPUP_LAYER);
}