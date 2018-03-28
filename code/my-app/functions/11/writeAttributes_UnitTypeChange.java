protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    if (newUnitType != null) {
        xw.writeAttribute(UNIT_TAG, newUnitType);
    }
    if (turnsToLearn != UNDEFINED) {
        xw.writeAttribute(TURNS_TO_LEARN_TAG, turnsToLearn);
    }
    for (Map.Entry<ChangeType, Integer> entry : changeTypes.entrySet()) {
        xw.writeAttribute(tags.get(entry.getKey()), entry.getValue().toString());
    }
}