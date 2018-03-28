public Dimension getPreferredSize(JComponent c) {
    String tipText = ((JToolTip) c).getTipText();
    if (tipText == null || tipText.isEmpty()) {
        return new Dimension(0, 0);
    }
    float x = 0f;
    float y = 0f;
    for (String line : lineBreak.split(tipText)) {
        if (line.isEmpty()) {
            y += LEADING;
            continue;
        }
        AttributedCharacterIterator styledText = new AttributedString(line).getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(styledText, frc);
        while (measurer.getPosition() < styledText.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(maximumWidth);
            x = Math.max(x, layout.getVisibleAdvance());
            y += layout.getAscent() + layout.getDescent() + layout.getLeading();
        }
    }
    return new Dimension((int) (x + 2 * margin), (int) (y + 2 * margin));
}