public boolean containsCenter(ServerRegion other) {
    int[] xy = other.getCenter();
    return bounds.contains(xy[0], xy[1]);
}