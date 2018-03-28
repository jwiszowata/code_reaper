public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (isRiver()) {
        if (style == null) {
            result = Math.min(-1, result);
            return result;
        }
        String conns = style.getString();
        int i = 0;
        for (Direction d : Direction.longSides) {
            Direction dReverse = d.getReverseDirection();
            Tile t = tile.getNeighbourOrNull(d);
            TileImprovement river = (t == null) ? null : t.getRiver();
            if (conns.charAt(i) != '0') {
                if (river != null) {
                    if (!river.isConnectedTo(dReverse)) {
                        logger.warning("Broken river connection to " + d + " at " + tile);
                        if (fix) {
                            setConnected(d, false);
                            result = Math.min(0, result);
                        } else
                            result = Math.min(-1, result);
                    }
                } else if (t == null || !t.getType().isWater()) {
                    logger.warning("Broken river connection to " + d + " at " + tile);
                    if (fix) {
                        setConnected(d, false);
                        result = Math.min(0, result);
                    } else
                        result = Math.min(-1, result);
                }
            }
            i++;
        }
    } else if (isRoad() && isComplete()) {
        if (fix) {
            TileImprovementStyle oldStyle = style;
            updateRoadConnections(true);
            if (style != oldStyle) {
                logger.warning("Fixing bad road style from " + oldStyle + " to " + style + " at " + tile);
                result = Math.min(0, result);
            }
        }
        if (style == null) {
            logger.warning("Broken road having null style at " + tile);
            result = Math.min(-1, result);
        }
    }
    return result;
}