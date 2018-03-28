protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    type = xr.getType(spec, NATION_TYPE_TAG, NationType.class, (NationType) null);
    selectable = xr.getAttribute(SELECTABLE_TAG, false);
    if (xr.hasAttribute(OLD_PREFERRED_LATITUDE_TAG)) {
        preferredLatitude = xr.getAttribute(OLD_PREFERRED_LATITUDE_TAG, 0);
    } else
        preferredLatitude = xr.getAttribute(PREFERRED_LATITUDE_TAG, 0);
    if (xr.hasAttribute(OLD_STARTS_ON_EAST_COAST_TAG)) {
        startsOnEastCoast = xr.getAttribute(OLD_STARTS_ON_EAST_COAST_TAG, true);
    } else
        startsOnEastCoast = xr.getAttribute(STARTS_ON_EAST_COAST_TAG, true);
    refNation = xr.getType(spec, REF_TAG, Nation.class, (Nation) null);
    int rgb = xr.getAttribute(COLOR_TAG, UNDEFINED);
    if (rgb != UNDEFINED)
        setColor(new Color(rgb));
}