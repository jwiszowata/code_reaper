protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    improvement = xr.makeFreeColObject(getGame(), IMPROVEMENT_TAG, TileImprovement.class, true);
}