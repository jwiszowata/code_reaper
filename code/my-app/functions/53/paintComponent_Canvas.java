public void paintComponent(Graphics g) {
    updateSizes();
    Graphics2D g2d = (Graphics2D) g;
    chatDisplay.removeOldMessages();
    Dimension size = getSize();
    if (freeColClient.isMapEditor()) {
        if (hasMap()) {
            mapViewer.displayMap(g2d);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, size.width, size.height);
        }
    } else if (freeColClient.isInGame() && hasMap()) {
        mapViewer.displayMap(g2d);
        if (!freeColClient.currentPlayerIsMyPlayer()) {
            if (greyLayer == null) {
                greyLayer = new GrayLayer(freeColClient);
            }
            if (greyLayer.getParent() == null) {
                add(greyLayer, JLayeredPane.DRAG_LAYER);
            }
            greyLayer.setBounds(0, 0, size.width, size.height);
            greyLayer.setPlayer(freeColClient.getGame().getCurrentPlayer());
        } else {
            if (greyLayer != null && greyLayer.getParent() != null) {
                removeFromCanvas(greyLayer);
            }
        }
        chatDisplay.display(g2d, mapViewer.getImageLibrary(), size);
    } else {
        final String bgImageKey = "image.flavor.Canvas.map";
        if (ResourceManager.hasImageResource(bgImageKey)) {
            final Image bgImage = ResourceManager.getImage(bgImageKey);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(bgImage, 0, 0, size.width, size.height, this);
            String versionStr = "v. " + FreeCol.getVersion();
            Font oldFont = g2d.getFont();
            Color oldColor = g2d.getColor();
            Font newFont = oldFont.deriveFont(Font.BOLD);
            TextLayout layout = new TextLayout(versionStr, newFont, g2d.getFontRenderContext());
            Rectangle2D bounds = layout.getBounds();
            float x = size.width - (float) bounds.getWidth() - 5;
            float y = size.height - (float) bounds.getHeight();
            g2d.setColor(Color.white);
            layout.draw(g2d, x, y);
            g2d.setFont(oldFont);
            g2d.setColor(oldColor);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, size.width, size.height);
        }
    }
}