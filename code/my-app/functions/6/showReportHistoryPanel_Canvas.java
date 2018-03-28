public void showReportHistoryPanel() {
    ReportHistoryPanel r = getExistingFreeColPanel(ReportHistoryPanel.class);
    if (r == null) {
        showSubPanel(new ReportHistoryPanel(freeColClient), true);
    }
}