protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    colonyId = xr.getAttribute(COLONY_TAG, (String) null);
    colonyName = xr.getAttribute(COLONY_NAME_TAG, (String) null);
}