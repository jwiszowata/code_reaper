protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (TILE_TYPE_CHANGE_TAG.equals(tag) || OLD_CHANGE_TAG.equals(tag)) {
        TileTypeChange change = new TileTypeChange(xr, spec);
        if (change != null)
            addChange(change);
    } else if (DISASTER_TAG.equals(tag)) {
        Disaster disaster = xr.getType(spec, ID_ATTRIBUTE_TAG, Disaster.class, (Disaster) null);
        int probability = xr.getAttribute(PROBABILITY_TAG, 100);
        addDisaster(disaster, probability);
        xr.closeTag(DISASTER_TAG);
    } else if (WORKER_TAG.equals(tag)) {
        addAllowedWorker(xr.readId());
        xr.closeTag(WORKER_TAG);
    } else {
        super.readChild(xr);
    }
}