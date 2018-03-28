public final long getConnectionsFromStyle() {
    long conn = 0L;
    if (style != null) {
        List<Direction> directions = getConnectionDirections();
        if (directions != null) {
            String mask = style.getMask();
            for (int i = 0; i < directions.size(); i++) {
                if (mask.charAt(i) != '0') {
                    conn |= 1L << directions.get(i).ordinal();
                }
            }
        }
    }
    return conn;
}