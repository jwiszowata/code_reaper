private void addColonyTile(ColonyTile ct) {
    if (ct == null)
        return;
    synchronized (colonyTiles) {
        colonyTiles.add(ct);
    }
}