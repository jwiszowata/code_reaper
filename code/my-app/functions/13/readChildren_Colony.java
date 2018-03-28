public void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    synchronized (colonyTiles) {
        colonyTiles.clear();
    }
    synchronized (buildingMap) {
        buildingMap.clear();
    }
    exportData.clear();
    buildQueue.clear();
    populationQueue.clear();
    super.readChildren(xr);
    invalidateCache();
}