public static void statistics(FreeColClient freeColClient) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game sGame = server.getGame();
    final Game cGame = freeColClient.getGame();
    final GUI gui = freeColClient.getGUI();
    java.util.Map<String, String> serverStats = sGame.getStatistics();
    serverStats.putAll(server.getAIMain().getAIStatistics());
    java.util.Map<String, String> clientStats = cGame.getStatistics();
    gui.showStatisticsPanel(serverStats, clientStats);
}