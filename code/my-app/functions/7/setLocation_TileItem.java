public boolean setLocation(Location newLocation) {
    if (newLocation == null || newLocation instanceof Tile) {
        tile = (Tile) newLocation;
        return true;
    }
    throw new IllegalArgumentException("newLocation is not a Tile");
}