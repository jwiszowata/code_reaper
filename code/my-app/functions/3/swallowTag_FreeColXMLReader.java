public void swallowTag(String tag) throws XMLStreamException {
    while (moreTags() || !tag.equals(getLocalName())) ;
}