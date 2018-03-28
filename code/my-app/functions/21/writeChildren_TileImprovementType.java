protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (allowedWorkers != null) {
        for (String id : allowedWorkers) {
            xw.writeStartElement(WORKER_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, id);
            xw.writeEndElement();
        }
    }
    if (tileTypeChanges != null) {
        for (Entry<TileType, TileTypeChange> e : mapEntriesByValue(tileTypeChanges)) {
            e.getValue().toXML(xw);
        }
    }
    for (RandomChoice<Disaster> choice : iterable(getDisasterChoices())) {
        xw.writeStartElement(DISASTER_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, choice.getObject().getId());
        xw.writeAttribute(PROBABILITY_TAG, choice.getProbability());
        xw.writeEndElement();
    }
}