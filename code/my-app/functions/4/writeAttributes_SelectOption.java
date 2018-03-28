protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(LOCALIZED_LABELS_TAG, localizedLabels);
}