protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(NUMBER_OF_SETTLEMENTS_TAG, numberOfSettlements);
    xw.writeAttribute(NUMBER_OF_UNITS_TAG, numberOfUnits);
    xw.writeAttribute(MILITARY_STRENGTH_TAG, militaryStrength);
    xw.writeAttribute(NAVAL_STRENGTH_TAG, navalStrength);
    xw.writeAttribute(STANCE_TAG, stance);
    xw.writeAttribute(GOLD_TAG, gold);
    if (soL >= 0) {
        xw.writeAttribute(SOL_TAG, soL);
    }
    if (foundingFathers >= 0) {
        xw.writeAttribute(FOUNDING_FATHERS_TAG, foundingFathers);
    }
    if (tax >= 0) {
        xw.writeAttribute(TAX_TAG, tax);
    }
}