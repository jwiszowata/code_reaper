public List<WorkLocation> getAllWorkLocationsList() {
    List<WorkLocation> ret = new ArrayList<>();
    synchronized (this.colonyTiles) {
        ret.addAll(this.colonyTiles);
    }
    synchronized (this.buildingMap) {
        ret.addAll(this.buildingMap.values());
    }
    return ret;
}