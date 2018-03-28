public Point[] getPoints(String text) {
    FAName fn = getFAName(text);
    if (fn != null) {
        return fn.points;
    }
    List<Point> points = new ArrayList<>();
    int x = 0;
    for (int i = 0; i < text.length(); i++) {
        FALetter fl = getLetter(text.charAt(i));
        for (int j = 0; j < fl.points.length; j++) {
            Point p = fl.points[j];
            points.add(new Point(p.x + x, p.y));
        }
        x += fl.advance;
    }
    return points.toArray(new Point[0]);
}