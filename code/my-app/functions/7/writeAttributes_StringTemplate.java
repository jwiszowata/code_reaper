protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TEMPLATE_TYPE_TAG, templateType);
    if (defaultId != null) {
        xw.writeAttribute(DEFAULT_ID_TAG, defaultId);
    }
}