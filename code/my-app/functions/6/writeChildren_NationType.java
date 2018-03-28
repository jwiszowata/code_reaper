protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (SettlementType settlementType : getSettlementTypes()) {
        settlementType.toXML(xw, SETTLEMENT_TAG);
    }
}