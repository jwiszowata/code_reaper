public void showReportTradePanel() {
    ReportTradePanel r = getExistingFreeColPanel(ReportTradePanel.class);
    if (r == null) {
        showSubPanel(new ReportTradePanel(freeColClient), true);
    }
}