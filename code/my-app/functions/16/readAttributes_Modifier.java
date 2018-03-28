protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    modifierType = xr.getAttribute(TYPE_TAG, ModifierType.class, (ModifierType) null);
    value = xr.getAttribute(VALUE_TAG, UNKNOWN);
    if (xr.hasAttribute(OLD_INCREMENT_TYPE_TAG)) {
        incrementType = xr.getAttribute(OLD_INCREMENT_TYPE_TAG, ModifierType.class, (ModifierType) null);
        increment = xr.getAttribute(INCREMENT_TAG, UNKNOWN);
    } else if (xr.hasAttribute(INCREMENT_TYPE_TAG)) {
        incrementType = xr.getAttribute(INCREMENT_TYPE_TAG, ModifierType.class, (ModifierType) null);
        increment = xr.getAttribute(INCREMENT_TAG, UNKNOWN);
    } else {
        incrementType = null;
        increment = 0;
    }
    modifierIndex = xr.getAttribute(INDEX_TAG, DEFAULT_MODIFIER_INDEX);
}