public boolean moreTags() throws XMLStreamException {
    return nextTag() != XMLStreamConstants.END_ELEMENT;
}