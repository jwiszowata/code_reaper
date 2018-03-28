protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (specification != null) {
        specification.toXML(xw);
    }
    for (String cityName : NameCache.getCitiesOfCibola()) {
        xw.writeStartElement(CIBOLA_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, cityName);
        xw.writeEndElement();
    }
    nationOptions.toXML(xw);
    List<Player> players = sort(getPlayers());
    Player unknown = getUnknownEnemy();
    if (unknown != null)
        players.add(unknown);
    for (Player p : players) p.toXML(xw);
    if (map != null)
        map.toXML(xw);
}