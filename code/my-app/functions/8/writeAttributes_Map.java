protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(WIDTH_TAG, getWidth());
    xw.writeAttribute(HEIGHT_TAG, getHeight());
    xw.writeAttribute(LAYER_TAG, layer);
    xw.writeAttribute(MINIMUM_LATITUDE_TAG, minimumLatitude);
    xw.writeAttribute(MAXIMUM_LATITUDE_TAG, maximumLatitude);
}