protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    String newId = xr.readId();
    if (newId != null)
        setId(newId);
}