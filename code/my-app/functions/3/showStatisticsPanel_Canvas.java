public void showStatisticsPanel(Map<String, String> serverStats, Map<String, String> clientStats) {
    showSubPanel(new StatisticsPanel(freeColClient, serverStats, clientStats), true);
}