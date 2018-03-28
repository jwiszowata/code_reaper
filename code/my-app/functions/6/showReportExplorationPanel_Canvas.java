public void showReportExplorationPanel() {
    ReportExplorationPanel r = getExistingFreeColPanel(ReportExplorationPanel.class);
    if (r == null) {
        showSubPanel(new ReportExplorationPanel(freeColClient), true);
    }
}