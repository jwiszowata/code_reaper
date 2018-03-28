protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    this.unitToSettlement.clear();
    this.settlementToUnit.clear();
    this.item = null;
    super.readChildren(xr);
}