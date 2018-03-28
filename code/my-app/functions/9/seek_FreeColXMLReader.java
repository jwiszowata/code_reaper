public FreeColXMLReader seek(String id) throws XMLStreamException {
    nextTag();
    for (int type = getEventType(); type != XMLEvent.END_DOCUMENT; type = getEventType()) {
        if (type == XMLEvent.START_ELEMENT && id.equals(readId()))
            return this;
        nextTag();
    }
    return null;
}