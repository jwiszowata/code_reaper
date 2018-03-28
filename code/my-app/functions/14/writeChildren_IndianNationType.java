protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (RandomChoice<UnitType> choice : getSkills()) {
        xw.writeStartElement(SKILL_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, choice.getObject());
        xw.writeAttribute(PROBABILITY_TAG, choice.getProbability());
        xw.writeEndElement();
    }
    for (String region : getRegionNames()) {
        xw.writeStartElement(Region.TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, region);
        xw.writeEndElement();
    }
}