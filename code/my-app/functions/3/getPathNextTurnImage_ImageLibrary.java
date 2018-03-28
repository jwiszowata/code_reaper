public static BufferedImage getPathNextTurnImage(Unit u) {
    return (u == null) ? null : getPathNextTurnImage(PathType.getPathType(u));
}