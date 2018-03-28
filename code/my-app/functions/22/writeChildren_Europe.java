protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (xw.validFor(getOwner())) {
        for (Ability ability : getSortedAbilities()) {
            ability.toXML(xw);
        }
        for (Modifier modifier : getSortedModifiers()) {
            modifier.toXML(xw);
        }
        for (UnitType unitType : sort(unitPrices.keySet())) {
            xw.writeStartElement(UNIT_PRICE_TAG);
            xw.writeAttribute(UNIT_TYPE_TAG, unitType);
            xw.writeAttribute(PRICE_TAG, unitPrices.get(unitType).intValue());
            xw.writeEndElement();
        }
        for (UnitType unitType : recruitables) {
            xw.writeStartElement(RECRUIT_TAG);
            xw.writeAttribute(RECRUIT_ID_TAG, unitType.getId());
            xw.writeEndElement();
        }
    }
}