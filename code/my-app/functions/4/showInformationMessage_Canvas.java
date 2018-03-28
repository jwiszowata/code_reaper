public void showInformationMessage(FreeColObject displayObject, Tile tile, ImageIcon icon, StringTemplate template) {
    String text = Messages.message(template);
    showFreeColPanel(new InformationPanel(freeColClient, text, displayObject, icon), tile, true);
}