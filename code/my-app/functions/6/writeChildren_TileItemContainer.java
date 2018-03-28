protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (TileItem item : getTileItems()) {
        item.toXML(xw);
    }
}