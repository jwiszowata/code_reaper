protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    contactLevels.clear();
    clearAlarm();
    missionary = null;
    clearOwnedUnits();
    super.readChildren(xr);
    for (Unit u : transform(getUnits(), u -> u.getLocation() != this)) {
        u.setLocationNoUpdate(this);
        logger.warning("Fixing unit location" + " from " + u.getLocation() + " to " + this.getId());
    }
}