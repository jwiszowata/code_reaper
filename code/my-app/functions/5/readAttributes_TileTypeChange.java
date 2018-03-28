protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    from = xr.getType(spec, FROM_TAG, TileType.class, (TileType) null);
    to = xr.getType(spec, TO_TAG, TileType.class, (TileType) null);
}