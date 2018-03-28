public void showModelMessages(List<ModelMessage> messages) {
    if (messages.isEmpty())
        return;
    final Game game = freeColClient.getGame();
    int n = messages.size();
    String[] texts = new String[n];
    FreeColObject[] fcos = new FreeColObject[n];
    ImageIcon[] icons = new ImageIcon[n];
    Tile tile = null;
    for (int i = 0; i < n; i++) {
        ModelMessage m = messages.get(i);
        texts[i] = Messages.message(m);
        fcos[i] = game.getMessageSource(m);
        icons[i] = createObjectImageIcon(game.getMessageDisplay(m));
        if (tile == null && fcos[i] instanceof Location) {
            tile = ((Location) fcos[i]).getTile();
        }
    }
    showFreeColPanel(new InformationPanel(freeColClient, texts, fcos, icons), tile, true);
}