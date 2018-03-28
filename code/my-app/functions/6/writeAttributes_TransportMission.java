protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (target != null) {
        xw.writeLocationAttribute(TARGET_TAG, target);
    }
}