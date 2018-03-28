public void showChatPanel() {
    if (freeColClient.getSinglePlayer())
        return;
    showSubPanel(chatPanel, true);
}