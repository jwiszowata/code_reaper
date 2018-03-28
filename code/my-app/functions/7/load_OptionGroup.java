protected boolean load(FreeColXMLReader xr) throws XMLStreamException {
    if (xr == null)
        return false;
    xr.nextTag();
    readFromXML(xr);
    return true;
}