protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (mission != null && !mission.isOneTime() && mission.isValid()) {
        mission.toXML(xw);
    }
}