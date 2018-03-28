public void showHighScoresPanel(String messageId, List<HighScore> scores) {
    showSubPanel(new ReportHighScoresPanel(freeColClient, messageId, scores), PopupPosition.CENTERED, true);
}