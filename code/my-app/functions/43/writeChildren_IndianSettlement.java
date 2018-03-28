protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (missionary != null) {
        xw.writeStartElement(MISSIONARY_TAG);
        missionary.toXML(xw);
        xw.writeEndElement();
    }
    if (xw.validFor(getOwner())) {
        for (Player p : sort(contactLevels.keySet())) {
            xw.writeStartElement(CONTACT_LEVEL_TAG);
            xw.writeAttribute(LEVEL_TAG, contactLevels.get(p));
            xw.writeAttribute(PLAYER_TAG, p);
            xw.writeEndElement();
        }
        for (Player p : sort(alarm.keySet())) {
            xw.writeStartElement(ALARM_TAG);
            xw.writeAttribute(PLAYER_TAG, p);
            xw.writeAttribute(VALUE_TAG, getAlarm(p).getValue());
            xw.writeEndElement();
        }
        for (Unit unit : sort(this.ownedUnits)) {
            xw.writeStartElement(OWNED_UNITS_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, unit);
            xw.writeEndElement();
        }
    } else {
        Player client = xw.getClientPlayer();
        ContactLevel cl = contactLevels.get(client);
        if (cl != null) {
            xw.writeStartElement(CONTACT_LEVEL_TAG);
            xw.writeAttribute(LEVEL_TAG, cl);
            xw.writeAttribute(PLAYER_TAG, client);
            xw.writeEndElement();
        }
        Tension alarm = getAlarm(client);
        if (alarm != null) {
            xw.writeStartElement(ALARM_TAG);
            xw.writeAttribute(PLAYER_TAG, client);
            xw.writeAttribute(VALUE_TAG, alarm.getValue());
            xw.writeEndElement();
        }
    }
}