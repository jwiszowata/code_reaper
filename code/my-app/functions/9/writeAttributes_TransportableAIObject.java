protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (transport != null) {
        Unit u = transport.getUnit();
        if (u != null && !u.isDisposed()) {
            xw.writeAttribute(TRANSPORT_TAG, u);
        }
    }
}