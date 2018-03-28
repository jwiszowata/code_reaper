protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    stance = xr.getAttribute(STANCE_TAG, Stance.class, Stance.PEACE);
    numberOfSettlements = xr.getAttribute(NUMBER_OF_SETTLEMENTS_TAG, -1);
    numberOfUnits = xr.getAttribute(NUMBER_OF_UNITS_TAG, -1);
    militaryStrength = xr.getAttribute(MILITARY_STRENGTH_TAG, -1);
    navalStrength = xr.getAttribute(NAVAL_STRENGTH_TAG, -1);
    gold = xr.getAttribute(GOLD_TAG, -1);
    soL = xr.getAttribute(SOL_TAG, -1);
    foundingFathers = xr.getAttribute(FOUNDING_FATHERS_TAG, -1);
    tax = xr.getAttribute(TAX_TAG, -1);
}