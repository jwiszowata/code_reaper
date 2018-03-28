public void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (inputs != null)
        inputs.clear();
    if (outputs != null)
        outputs.clear();
    super.readChildren(xr);
}