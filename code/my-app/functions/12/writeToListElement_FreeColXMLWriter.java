public <T extends FreeColObject> void writeToListElement(String tag, Collection<T> members) throws XMLStreamException {
    if (members.isEmpty())
        return;
    writeStartElement(tag);
    writeAttribute(FreeColObject.ARRAY_SIZE_TAG, members.size());
    int i = 0;
    for (T t : members) {
        writeAttribute(FreeColObject.arrayKey(i), t);
        i++;
    }
    writeEndElement();
}