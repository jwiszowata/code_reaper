public int nextTag() throws XMLStreamException {
    int tag = super.nextTag();
    if (tracing) {
        switch(tag) {
            case XMLStreamConstants.START_ELEMENT:
                System.err.println("[" + getLocalName());
                break;
            case XMLStreamConstants.END_ELEMENT:
                System.err.println(getLocalName() + "]");
                break;
            default:
                System.err.println((tagStrings.containsKey(tag)) ? tagStrings.get(tag) : "Weird tag: " + tag);
                break;
        }
    }
    return tag;
}