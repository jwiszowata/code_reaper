public void showEventPanel(String header, String image, String footer) {
    showSubPanel(new EventPanel(freeColClient, header, image, footer), PopupPosition.CENTERED, false);
}