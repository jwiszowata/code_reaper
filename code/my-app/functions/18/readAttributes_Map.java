protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    setLayer(xr.getAttribute(LAYER_TAG, Layer.class, Layer.ALL));
    if (this.tiles == null) {
        int width = xr.getAttribute(WIDTH_TAG, -1);
        if (width < 0) {
            throw new XMLStreamException("Bogus width: " + width);
        }
        int height = xr.getAttribute(HEIGHT_TAG, -1);
        if (height < 0) {
            throw new XMLStreamException("Bogus height: " + height);
        }
        this.tiles = new Tile[width][height];
    }
    minimumLatitude = xr.getAttribute(MINIMUM_LATITUDE_TAG, -90);
    maximumLatitude = xr.getAttribute(MAXIMUM_LATITUDE_TAG, 90);
    calculateLatitudePerRow();
}