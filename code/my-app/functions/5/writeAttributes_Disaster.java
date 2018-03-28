protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NATURAL_TAG, natural);
    xw.writeAttribute(EFFECTS_TAG, numberOfEffects);
}