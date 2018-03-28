protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final AIMain aiMain = getAIMain();
    unit = xr.findFreeColGameObject(aiMain.getGame(), ID_ATTRIBUTE_TAG, Unit.class, (Unit) null, true);
    if (!unit.isInitialized()) {
        xr.nextTag();
        throw new XMLStreamException("AIUnit for uninitialized Unit: " + unit.getId());
    }
}