protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    long l = date.getTime();
    xw.writeAttribute(DATE_TAG, l);
    xw.writeAttribute(RETIREMENT_TURN_TAG, retirementTurn);
    xw.writeAttribute(INDEPENDENCE_TURN_TAG, independenceTurn);
    xw.writeAttribute(PLAYER_NAME_TAG, playerName);
    xw.writeAttribute(NATION_ID_TAG, nationId);
    xw.writeAttribute(NATION_TYPE_ID_TAG, nationTypeId);
    xw.writeAttribute(SCORE_TAG, score);
    xw.writeAttribute(LEVEL_TAG, level.toString());
    if (nationName != null) {
        xw.writeAttribute(NATION_NAME_TAG, nationName);
    }
    if (newLandName != null) {
        xw.writeAttribute(NEW_LAND_NAME_TAG, newLandName);
    }
    xw.writeAttribute(DIFFICULTY_TAG, difficulty);
    xw.writeAttribute(UNITS_TAG, nUnits);
    xw.writeAttribute(COLONIES_TAG, nColonies);
}