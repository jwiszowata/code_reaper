protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    NameCache.clearCitiesOfCibola();
    players.clear();
    unknownEnemy = null;
    String current = xr.getAttribute(CURRENT_PLAYER_TAG, (String) null);
    super.readChildren(xr);
    currentPlayer = (current == null) ? null : getFreeColGameObject(current, Player.class);
    for (Colony c : getAllColoniesList(null)) {
        c.updateProductionTypes();
    }
}