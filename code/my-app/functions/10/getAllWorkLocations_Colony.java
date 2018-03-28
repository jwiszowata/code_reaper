public Stream<WorkLocation> getAllWorkLocations() {
    Stream<WorkLocation> ret = Stream.<WorkLocation>empty();
    synchronized (this.colonyTiles) {
        ret = concat(ret, map(this.colonyTiles, ct -> (WorkLocation) ct));
    }
    synchronized (this.buildingMap) {
        ret = concat(ret, map(this.buildingMap.values(), b -> (WorkLocation) b));
    }
    return ret;
}