protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (Cargo.TAG.equals(tag)) {
        tAdd(new Cargo(getAIMain(), xr), -1);
    } else {
        super.readChild(xr);
    }
}