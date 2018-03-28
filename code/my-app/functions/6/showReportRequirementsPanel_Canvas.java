public void showReportRequirementsPanel() {
    ReportRequirementsPanel r = getExistingFreeColPanel(ReportRequirementsPanel.class);
    if (r == null) {
        showSubPanel(new ReportRequirementsPanel(freeColClient), true);
    }
}