public void expectTag(String tag) throws XMLStreamException {
    final String endTag = getLocalName();
    if (!endTag.equals(tag)) {
        throw new XMLStreamException("Parse error, " + tag + " expected, not: " + endTag);
    }
}