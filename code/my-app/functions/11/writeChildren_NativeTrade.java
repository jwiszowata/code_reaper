protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    xw.writeStartElement(SETTLEMENT_TO_UNIT_TAG);
    for (NativeTradeItem nti : this.settlementToUnit) nti.toXML(xw);
    xw.writeEndElement();
    xw.writeStartElement(UNIT_TO_SETTLEMENT_TAG);
    for (NativeTradeItem nti : this.unitToSettlement) nti.toXML(xw);
    xw.writeEndElement();
    if (this.item != null)
        this.item.toXML(xw);
}