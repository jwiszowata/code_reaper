public static BufferedImage getPathImage(Unit u) {
    return (u == null) ? null : getPathImage(PathType.getPathType(u));
}