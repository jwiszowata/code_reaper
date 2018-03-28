public void showReportReligiousPanel() {
    ReportReligiousPanel r = getExistingFreeColPanel(ReportReligiousPanel.class);
    if (r == null) {
        showSubPanel(new ReportReligiousPanel(freeColClient), true);
    }
}