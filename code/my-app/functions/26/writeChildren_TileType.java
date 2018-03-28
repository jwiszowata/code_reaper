protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    xw.writeStartElement(GEN_TAG);
    xw.writeAttribute(HUMIDITY_MIN_TAG, humidity[0]);
    xw.writeAttribute(HUMIDITY_MAX_TAG, humidity[1]);
    xw.writeAttribute(TEMPERATURE_MIN_TAG, temperature[0]);
    xw.writeAttribute(TEMPERATURE_MAX_TAG, temperature[1]);
    xw.writeAttribute(ALTITUDE_MIN_TAG, altitude[0]);
    xw.writeAttribute(ALTITUDE_MAX_TAG, altitude[1]);
    xw.writeEndElement();
    for (ProductionType productionType : productionTypes) {
        productionType.toXML(xw);
    }
    for (RandomChoice<ResourceType> choice : getWeightedResources()) {
        xw.writeStartElement(RESOURCE_TAG);
        xw.writeAttribute(TYPE_TAG, choice.getObject());
        xw.writeAttribute(PROBABILITY_TAG, choice.getProbability());
        xw.writeEndElement();
    }
    for (RandomChoice<Disaster> choice : iterable(getDisasterChoices())) {
        xw.writeStartElement(DISASTER_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, choice.getObject());
        xw.writeAttribute(PROBABILITY_TAG, choice.getProbability());
        xw.writeEndElement();
    }
}