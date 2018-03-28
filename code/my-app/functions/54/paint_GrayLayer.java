public void paint(Graphics g) {
    Rectangle clipArea = g.getClipBounds();
    if (clipArea == null) {
        clipArea = getBounds();
        clipArea.x = clipArea.y = 0;
    }
    if (clipArea.isEmpty()) {
        return;
    }
    if (!freeColClient.getClientOptions().getBoolean(ClientOptions.DISABLE_GRAY_LAYER)) {
        g.setColor(MASK_COLOR);
        g.fillRect(clipArea.x, clipArea.y, clipArea.width, clipArea.height);
    }
    ImageIcon coatOfArmsIcon = null;
    String message = null;
    Color colour = null;
    if (player == null) {
        message = Messages.message(freeColClient.getGame().getTurn().getLabel());
        colour = Color.WHITE;
    } else {
        coatOfArmsIcon = new ImageIcon(ImageLibrary.getMiscIconImage(player.getNation(), 1f));
        message = Messages.message(player.getWaitingLabel());
        colour = player.getNationColor();
    }
    Font nameFont = getFont();
    FontMetrics nameFontMetrics = getFontMetrics(nameFont);
    Rectangle textBounds;
    int fontSize = DEFAULT_FONT_SIZE;
    int maxWidth = Math.min(MAX_TEXT_WIDTH, getSize().width);
    do {
        nameFont = nameFont.deriveFont(Font.BOLD, fontSize);
        nameFontMetrics = getFontMetrics(nameFont);
        textBounds = nameFontMetrics.getStringBounds(message, g).getBounds();
        fontSize -= FONT_SIZE_DECREMENT;
    } while (textBounds.width > maxWidth);
    Dimension size = getSize();
    textBounds.x = (size.width - textBounds.width) / 2;
    textBounds.y = size.height - InfoPanel.PANEL_HEIGHT - 2 * textBounds.height;
    if (textBounds.intersects(clipArea)) {
        g.setFont(nameFont);
        g.setColor(colour);
        g.drawString(message, textBounds.x, textBounds.y + textBounds.height);
    }
    if (coatOfArmsIcon != null) {
        Rectangle iconBounds = new Rectangle();
        iconBounds.width = coatOfArmsIcon.getIconWidth();
        iconBounds.height = coatOfArmsIcon.getIconHeight();
        iconBounds.x = (size.width - iconBounds.width) / 2;
        iconBounds.y = textBounds.y + 3 * textBounds.height / 2;
        if (iconBounds.intersects(clipArea)) {
            coatOfArmsIcon.paintIcon(this, g, iconBounds.x, iconBounds.y);
        }
    }
}