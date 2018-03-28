public void toXML(FreeColXMLWriter xw) throws XMLStreamException {
    xw.writeStartElement(TAG);
    xw.writeAttribute(FreeColObject.ID_ATTRIBUTE_TAG, getId());
    xw.writeAttribute(ACCELERATOR_TAG, getKeyStrokeText(getAccelerator()));
    xw.writeEndElement();
}