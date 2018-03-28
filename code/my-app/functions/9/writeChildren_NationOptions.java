public void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Nation nation : sort(nations.keySet())) {
        xw.writeStartElement(NATION_OPTION_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, nation);
        xw.writeAttribute(STATE_TAG, nations.get(nation));
        xw.writeEndElement();
    }
}