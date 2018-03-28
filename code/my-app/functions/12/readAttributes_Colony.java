public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    established = new Turn(xr.getAttribute(ESTABLISHED_TAG, 0));
    sonsOfLiberty = xr.getAttribute(SONS_OF_LIBERTY_TAG, 0);
    oldSonsOfLiberty = xr.getAttribute(OLD_SONS_OF_LIBERTY_TAG, 0);
    tories = xr.getAttribute(TORIES_TAG, 0);
    oldTories = xr.getAttribute(OLD_TORIES_TAG, 0);
    liberty = xr.getAttribute(LIBERTY_TAG, 0);
    immigration = xr.getAttribute(IMMIGRATION_TAG, 0);
    productionBonus = xr.getAttribute(PRODUCTION_BONUS_TAG, 0);
    displayUnitCount = xr.getAttribute(UNIT_COUNT_TAG, -1);
}