protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (keys != null)
        keys.clear();
    if (replacements != null)
        replacements.clear();
    super.readChildren(xr);
}