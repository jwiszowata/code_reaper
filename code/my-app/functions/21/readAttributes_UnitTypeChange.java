protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    newUnitType = xr.getType(spec, UNIT_TAG, UnitType.class, (UnitType) null);
    if (xr.hasAttribute(OLD_TURNS_TO_LEARN_TAG)) {
        turnsToLearn = xr.getAttribute(OLD_TURNS_TO_LEARN_TAG, UNDEFINED);
    } else
        turnsToLearn = xr.getAttribute(TURNS_TO_LEARN_TAG, UNDEFINED);
    for (ChangeType type : ChangeType.values()) {
        int value = xr.getAttribute(tags.get(type), -1);
        if (value < 0) {
            String x = compatTags.get(type);
            if (x != null)
                value = xr.getAttribute(x, -1);
        }
        if (value >= 0) {
            changeTypes.put(type, Math.min(100, value));
        }
    }
    if (turnsToLearn > 0)
        changeTypes.put(ChangeType.EDUCATION, 100);
}