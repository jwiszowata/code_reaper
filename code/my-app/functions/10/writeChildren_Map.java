protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Region region : sort(regions)) region.toXML(xw);
    final int hgt = getHeight(), wid = getWidth();
    for (int y = 0; y < hgt; y++) {
        for (int x = 0; x < wid; x++) {
            this.tiles[x][y].toXML(xw);
        }
    }
}