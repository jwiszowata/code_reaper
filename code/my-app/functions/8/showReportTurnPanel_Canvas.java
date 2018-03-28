public void showReportTurnPanel(List<ModelMessage> messages) {
    ReportTurnPanel r = getExistingFreeColPanel(ReportTurnPanel.class);
    if (r == null) {
        showSubPanel(new ReportTurnPanel(freeColClient, messages), true);
    } else {
        r.setMessages(messages);
    }
}