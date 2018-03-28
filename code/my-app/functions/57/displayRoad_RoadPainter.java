public void displayRoad(Graphics2D g, Tile tile) {
    Color oldColor = g.getColor();
    g.setColor(ResourceManager.getColor("color.map.road"));
    g.setStroke(roadStroke);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    final Map map = tile.getMap();
    final int x = tile.getX();
    final int y = tile.getY();
    final Predicate<Direction> borderPred = d -> {
        Tile borderingTile = map.getTile(d.step(x, y));
        TileImprovement r;
        return borderingTile != null && (r = borderingTile.getRoad()) != null && r.isComplete();
    };
    List<Direction> directions = transform(Direction.allDirections, borderPred);
    List<Point2D.Float> points = transform(directions, alwaysTrue(), d -> corners.get(d));
    GeneralPath path = new GeneralPath();
    switch(points.size()) {
        case 0:
            path.moveTo(0.35f * tileWidth, 0.35f * tileHeight);
            path.lineTo(0.65f * tileWidth, 0.65f * tileHeight);
            path.moveTo(0.35f * tileWidth, 0.65f * tileHeight);
            path.lineTo(0.65f * tileWidth, 0.35f * tileHeight);
            break;
        case 1:
            path.moveTo(halfWidth, halfHeight);
            path.lineTo(points.get(0).getX(), points.get(0).getY());
            break;
        case 2:
            path.moveTo(points.get(0).getX(), points.get(0).getY());
            path.quadTo(halfWidth, halfHeight, points.get(1).getX(), points.get(1).getY());
            break;
        case 3:
        case 4:
            Direction pen = directions.get(directions.size() - 1);
            Point2D pt = corners.get(pen);
            path.moveTo(pt.getX(), pt.getY());
            for (Direction d : directions) {
                pt = corners.get(d);
                if (prohibitedRoads.get(pen).contains(d)) {
                    path.moveTo(pt.getX(), pt.getY());
                } else {
                    path.quadTo(halfWidth, halfHeight, pt.getX(), pt.getY());
                }
                pen = d;
            }
            break;
        default:
            for (Point2D p : points) {
                path.moveTo(halfWidth, halfHeight);
                path.lineTo(p.getX(), p.getY());
            }
            break;
    }
    g.draw(path);
    g.setColor(oldColor);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
}