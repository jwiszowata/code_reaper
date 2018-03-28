protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Mission mission : missions) {
        mission.toXML(xw);
    }
}