public void paint(Graphics g, JComponent c) {
    if (c.isOpaque()) {
        ImageLibrary.drawTiledImage("image.background.FreeColToolTip", g, c, null);
    }
    g.setColor(Color.BLACK);
    Graphics2D graphics = (Graphics2D) g;
    float x = margin;
    float y = margin;
    for (String line : lineBreak.split(((JToolTip) c).getTipText())) {
        if (line.isEmpty()) {
            y += LEADING;
            continue;
        }
        AttributedCharacterIterator styledText = new AttributedString(line).getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(styledText, frc);
        while (measurer.getPosition() < styledText.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(maximumWidth);
            y += (layout.getAscent());
            float dx = layout.isLeftToRight() ? 0 : (maximumWidth - layout.getAdvance());
            layout.draw(graphics, x + dx, y);
            y += layout.getDescent() + layout.getLeading();
        }
    }
}