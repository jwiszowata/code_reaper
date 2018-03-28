public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (BUILD_QUEUE_TAG.equals(tag)) {
        BuildableType bt = xr.getType(spec, ID_ATTRIBUTE_TAG, BuildableType.class, (BuildableType) null);
        if (bt != null)
            buildQueue.add(bt);
        xr.closeTag(BUILD_QUEUE_TAG);
    } else if (POPULATION_QUEUE_TAG.equals(xr.getLocalName())) {
        UnitType ut = xr.getType(spec, ID_ATTRIBUTE_TAG, UnitType.class, (UnitType) null);
        if (ut != null)
            populationQueue.add(ut);
        xr.closeTag(POPULATION_QUEUE_TAG);
    } else if (Building.TAG.equals(tag)) {
        addBuilding(xr.readFreeColObject(game, Building.class));
    } else if (ColonyTile.TAG.equals(tag)) {
        addColonyTile(xr.readFreeColObject(game, ColonyTile.class));
    } else if (ExportData.TAG.equals(tag)) {
        ExportData data = new ExportData(xr);
        setExportData(data);
    } else {
        super.readChild(xr);
    }
}