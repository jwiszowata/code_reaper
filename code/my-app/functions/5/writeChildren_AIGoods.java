protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (goods != null)
        goods.toXML(xw);
}