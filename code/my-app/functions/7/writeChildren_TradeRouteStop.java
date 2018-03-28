public void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    for (GoodsType cargoType : cargo) {
        xw.writeStartElement(CARGO_TAG);
        xw.writeAttribute(FreeColObject.ID_ATTRIBUTE_TAG, cargoType);
        xw.writeEndElement();
    }
}