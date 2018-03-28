public void showReportEducationPanel() {
    ReportEducationPanel r = getExistingFreeColPanel(ReportEducationPanel.class);
    if (r == null) {
        showSubPanel(new ReportEducationPanel(freeColClient), true);
    }
}