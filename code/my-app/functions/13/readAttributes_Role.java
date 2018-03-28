protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    downgrade = xr.getType(spec, DOWNGRADE_TAG, Role.class, (Role) null);
    if (xr.hasAttribute(OLD_EXPERT_UNIT_TAG)) {
        expertUnit = xr.getType(spec, OLD_EXPERT_UNIT_TAG, UnitType.class, (UnitType) null);
    } else
        expertUnit = xr.getType(spec, EXPERT_UNIT_TAG, UnitType.class, (UnitType) null);
    if (xr.hasAttribute(OLD_MAXIMUM_COUNT_TAG)) {
        maximumCount = xr.getAttribute(OLD_MAXIMUM_COUNT_TAG, 1);
    } else
        maximumCount = xr.getAttribute(MAXIMUM_COUNT_TAG, 1);
}