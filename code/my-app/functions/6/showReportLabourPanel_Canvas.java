public void showReportLabourPanel() {
    ReportLabourPanel r = getExistingFreeColPanel(ReportLabourPanel.class);
    if (r == null) {
        showSubPanel(new ReportLabourPanel(freeColClient), true);
    }
}