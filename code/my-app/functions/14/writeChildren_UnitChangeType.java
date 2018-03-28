protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Map.Entry<UnitType, List<UnitChange>> entry : this.changes.entrySet()) {
        for (UnitChange uc : entry.getValue()) {
            xw.writeStartElement(UNIT_TYPE_CHANGE_TAG);
            xw.writeAttribute(FROM_TAG, entry.getKey());
            xw.writeAttribute(TO_TAG, uc.to);
            xw.writeAttribute(PROBABILITY_TAG, uc.probability);
            if (uc.turns > 0)
                xw.writeAttribute(TURNS_TAG, uc.turns);
            xw.writeEndElement();
        }
    }
}