public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    for (TileItem ti : getTileItems()) {
        int integ = ti.checkIntegrity(fix);
        if (fix) {
            if (ti.getTile() != tile) {
                logger.warning("Fixing improvement tile at: " + tile + " / " + ti.getId());
                ti.setLocation(tile);
                integ = Math.min(integ, 0);
            }
            if (ti instanceof TileImprovement) {
                TileImprovement tim = (TileImprovement) ti;
                if (tim.isRiver()) {
                    if (tim.getStyle() == null) {
                        logger.warning("Style null river: " + tim);
                        integ = -1;
                    } else if ("0000".equals(tim.getStyle().toString())) {
                        logger.warning("Style 0000 river: " + tim);
                        integ = -1;
                    }
                }
            }
            if (integ < 0) {
                logger.warning("Removing broken improvement at: " + tile + " / " + ti.getId());
                removeTileItem(ti);
                integ = 0;
            }
        }
        result = Math.min(result, integ);
    }
    return result;
}