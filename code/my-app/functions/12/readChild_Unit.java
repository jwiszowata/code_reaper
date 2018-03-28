protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (OLD_EQUIPMENT_TAG.equals(tag)) {
        xr.swallowTag(OLD_EQUIPMENT_TAG);
    } else if (TileImprovement.TAG.equals(tag) || OLD_TILE_IMPROVEMENT_TAG.equals(tag)) {
        workImprovement = xr.readFreeColObject(game, TileImprovement.class);
    } else {
        super.readChild(xr);
    }
}