public void showServerListPanel(List<ServerInfo> serverList) {
    closeMenus();
    serverListPanel.initialize(serverList);
    showSubPanel(serverListPanel, true);
}