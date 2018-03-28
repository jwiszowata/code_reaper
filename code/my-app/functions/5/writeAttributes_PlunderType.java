protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (this.range != null)
        this.range.writeAttributes(xw);
}