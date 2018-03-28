public Dimension getDimension(String text) {
    FAName fn = getFAName(text);
    if (fn != null) {
        return new Dimension(fn.width, fn.height);
    }
    int width = 0;
    for (int i = 0; i < text.length(); i++) {
        FALetter fl = getLetter(text.charAt(i));
        width += fl.advance;
    }
    int firstMinX = Integer.MAX_VALUE;
    FALetter letter = getLetter(text.charAt(0));
    for (int i = 0; i < letter.points.length; i++) {
        Point p = letter.points[i];
        if (p.x < firstMinX) {
            firstMinX = p.x;
        }
    }
    width += firstMinX;
    int lastMaxX = 0;
    letter = getLetter(text.charAt(text.length() - 1));
    for (int i = 0; i < letter.points.length; i++) {
        Point p = letter.points[i];
        if (p.x > lastMaxX) {
            lastMaxX = p.x;
        }
    }
    width += lastMaxX;
    return new Dimension(width, maxHeight);
}