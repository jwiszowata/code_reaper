protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    settlement = null;
    super.readChildren(xr);
    if (getSettlement() != null) {
        Settlement settlement = getSettlement();
        Player owner = settlement.getOwner();
        if (owner != null && getOwner() != owner) {
            this.owner = owner;
        }
        if (this.owningSettlement != settlement) {
            this.owningSettlement = settlement;
        }
    }
}