protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (Ability.TAG.equals(tag)) {
        addAbility(new Ability(xr, spec));
    } else if (Modifier.TAG.equals(tag)) {
        addModifier(new Modifier(xr, spec));
    } else if (RECRUIT_TAG.equals(tag)) {
        UnitType unitType = xr.getType(spec, RECRUIT_ID_TAG, UnitType.class, (UnitType) null);
        if (unitType != null)
            addRecruitable(unitType);
        xr.closeTag(RECRUIT_TAG);
    } else if (UNIT_PRICE_TAG.equals(tag)) {
        UnitType unitType = xr.getType(spec, UNIT_TYPE_TAG, UnitType.class, (UnitType) null);
        int price = xr.getAttribute(PRICE_TAG, -1);
        unitPrices.put(unitType, price);
        xr.closeTag(UNIT_PRICE_TAG);
    } else {
        super.readChild(xr);
    }
}