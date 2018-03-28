public void animate() {
    final int movementSpeed = getFreeColClient().getAnimationSpeed(unit.getOwner());
    final SwingGUI gui = (SwingGUI) getGUI();
    final Point srcP = gui.getTilePosition(sourceTile);
    final Point dstP = gui.getTilePosition(destinationTile);
    if (srcP == null || dstP == null || movementSpeed <= 0)
        return;
    float scale = gui.getMapScale();
    final int movementRatio = (int) (Math.pow(2, movementSpeed + 1) * scale);
    final Rectangle r1 = gui.getTileBounds(sourceTile);
    final Rectangle r2 = gui.getTileBounds(destinationTile);
    final Rectangle bounds = r1.union(r2);
    gui.executeWithUnitOutForAnimation(unit, sourceTile, (JLabel unitLabel) -> {
        final int labelWidth = unitLabel.getWidth();
        final int labelHeight = unitLabel.getHeight();
        final Point srcPoint = gui.calculateUnitLabelPositionInTile(labelWidth, labelHeight, srcP);
        final Point dstPoint = gui.calculateUnitLabelPositionInTile(labelWidth, labelHeight, dstP);
        final double xratio = ImageLibrary.TILE_SIZE.width / (double) ImageLibrary.TILE_SIZE.height;
        final int stepX = (srcPoint.getX() == dstPoint.getX()) ? 0 : (srcPoint.getX() > dstPoint.getX()) ? -1 : 1;
        final int stepY = (srcPoint.getY() == dstPoint.getY()) ? 0 : (srcPoint.getY() > dstPoint.getY()) ? -1 : 1;
        gui.paintImmediatelyCanvasInItsBounds();
        int dropFrames = 0;
        Point point = srcPoint;
        while (!point.equals(dstPoint)) {
            long time = System.currentTimeMillis();
            point.x += stepX * xratio * movementRatio;
            point.y += stepY * movementRatio;
            if ((stepX < 0 && point.x < dstPoint.x) || (stepX > 0 && point.x > dstPoint.x)) {
                point.x = dstPoint.x;
            }
            if ((stepY < 0 && point.y < dstPoint.y) || (stepY > 0 && point.y > dstPoint.y)) {
                point.y = dstPoint.y;
            }
            if (dropFrames <= 0) {
                unitLabel.setLocation(point);
                gui.paintImmediatelyCanvasIn(bounds);
                int timeTaken = (int) (System.currentTimeMillis() - time);
                final int waitTime = ANIMATION_DELAY - timeTaken;
                if (waitTime > 0) {
                    Utils.delay(waitTime, "Animation interrupted.");
                    dropFrames = 0;
                } else {
                    dropFrames = timeTaken / ANIMATION_DELAY - 1;
                }
            } else {
                dropFrames--;
            }
        }
    });
}