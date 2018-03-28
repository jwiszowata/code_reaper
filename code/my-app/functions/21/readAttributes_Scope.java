protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.hasAttribute(OLD_MATCH_NEGATED_TAG)) {
        matchNegated = xr.getAttribute(OLD_MATCH_NEGATED_TAG, false);
    } else
        matchNegated = xr.getAttribute(MATCH_NEGATED_TAG, false);
    if (xr.hasAttribute(OLD_MATCHES_NULL_TAG)) {
        matchesNull = xr.getAttribute(OLD_MATCHES_NULL_TAG, true);
    } else
        matchesNull = xr.getAttribute(MATCHES_NULL_TAG, true);
    type = xr.getAttribute(TYPE_TAG, (String) null);
    abilityId = xr.getAttribute(ABILITY_ID_TAG, (String) null);
    abilityValue = xr.getAttribute(ABILITY_VALUE_TAG, true);
    if (xr.hasAttribute(OLD_METHOD_NAME_TAG)) {
        methodName = xr.getAttribute(OLD_METHOD_NAME_TAG, (String) null);
    } else
        methodName = xr.getAttribute(METHOD_NAME_TAG, (String) null);
    if (xr.hasAttribute(OLD_METHOD_VALUE_TAG)) {
        methodValue = xr.getAttribute(OLD_METHOD_VALUE_TAG, (String) null);
    } else
        methodValue = xr.getAttribute(METHOD_VALUE_TAG, (String) null);
}