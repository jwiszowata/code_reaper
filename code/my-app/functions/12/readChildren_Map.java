protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    fixupHighSeas = false;
    super.readChildren(xr);
    if (fixupHighSeas)
        resetHighSeasCount();
    forEachTile(t -> {
        Settlement s = t.getOwningSettlement();
        if (s != null)
            s.addTile(t);
    });
    fixupRegions();
}