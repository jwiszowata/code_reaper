protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (this.plunder != null) {
        for (PlunderType pt : this.plunder) pt.toXML(xw);
    }
    if (this.gifts != null) {
        xw.writeStartElement(GIFTS_TAG);
        this.gifts.writeAttributes(xw);
        xw.writeEndElement();
    }
}