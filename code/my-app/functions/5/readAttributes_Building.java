protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    buildingType = xr.getType(spec, BUILDING_TYPE_TAG, BuildingType.class, (BuildingType) null);
}