public void showReportForeignAffairPanel() {
    ReportForeignAffairPanel r = getExistingFreeColPanel(ReportForeignAffairPanel.class);
    if (r == null) {
        showSubPanel(new ReportForeignAffairPanel(freeColClient), true);
    }
}