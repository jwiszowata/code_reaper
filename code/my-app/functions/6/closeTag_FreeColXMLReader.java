public void closeTag(String tag) throws XMLStreamException {
    if (moreTags()) {
        throw new XMLStreamException("Parse error, END_ELEMENT expected," + " not: " + getLocalName());
    }
    expectTag(tag);
}