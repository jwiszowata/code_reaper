public Element toXMLElement() {
    return new DOMMessage(TAG, UNIT_TAG, this.unitId, SETTLEMENT_TAG, this.settlementId).add(this.goods).toXMLElement();
}