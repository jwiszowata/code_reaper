protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NATION_TYPE_TAG, type);
    xw.writeAttribute(SELECTABLE_TAG, selectable);
    xw.writeAttribute(PREFERRED_LATITUDE_TAG, preferredLatitude);
    xw.writeAttribute(STARTS_ON_EAST_COAST_TAG, startsOnEastCoast);
    if (refNation != null)
        xw.writeAttribute(REF_TAG, refNation);
    if (color != null)
        xw.writeAttribute(COLOR_TAG, color.getRGB());
}