public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    for (int index = 0; index < 3; index++) {
        UnitType unitType = xr.getType(spec, RECRUIT_TAG + index, UnitType.class, (UnitType) null);
        if (unitType != null) {
            addRecruitable(unitType);
            clearRecruitables = false;
        }
    }
    owner = xr.findFreeColGameObject(getGame(), OWNER_TAG, Player.class, (Player) null, true);
    recruitPrice = xr.getAttribute(RECRUIT_PRICE_TAG, RECRUIT_PRICE_INITIAL);
    recruitLowerCap = xr.getAttribute(RECRUIT_LOWER_CAP_TAG, LOWER_CAP_INITIAL);
}