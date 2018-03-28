public Tile getWorkTile() {
    return (getLocation() instanceof WorkLocation) ? ((WorkLocation) getLocation()).getWorkTile() : null;
}