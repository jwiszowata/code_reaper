public void showReportNavalPanel() {
    ReportNavalPanel r = getExistingFreeColPanel(ReportNavalPanel.class);
    if (r == null) {
        showSubPanel(new ReportNavalPanel(freeColClient), true);
    }
}