private static MigLayout createLayout(FreeColClient freeColClient) {
    BufferedImage skin = getSkin(freeColClient);
    int w = skin.getWidth();
    int h = skin.getHeight();
    return new MigLayout("wrap 1, insets " + (h - 290) + " 10 10 10", "[" + (w - 2 * 10) + "]", "[240]10[20]");
}