protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    xw.writeAttribute(MATCH_NEGATED_TAG, matchNegated);
    xw.writeAttribute(MATCHES_NULL_TAG, matchesNull);
    if (type != null) {
        xw.writeAttribute(TYPE_TAG, type);
    }
    if (abilityId != null) {
        xw.writeAttribute(ABILITY_ID_TAG, abilityId);
        xw.writeAttribute(ABILITY_VALUE_TAG, abilityValue);
    }
    if (methodName != null) {
        xw.writeAttribute(METHOD_NAME_TAG, methodName);
        if (methodValue != null) {
            xw.writeAttribute(METHOD_VALUE_TAG, methodValue);
        }
    }
}