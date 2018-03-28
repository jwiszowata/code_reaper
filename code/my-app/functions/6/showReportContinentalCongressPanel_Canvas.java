public void showReportContinentalCongressPanel() {
    ReportContinentalCongressPanel r = getExistingFreeColPanel(ReportContinentalCongressPanel.class);
    if (r == null) {
        showSubPanel(new ReportContinentalCongressPanel(freeColClient), true);
    }
}