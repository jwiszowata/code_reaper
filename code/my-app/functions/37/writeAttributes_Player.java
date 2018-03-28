protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(USERNAME_TAG, name);
    xw.writeAttribute(NATION_ID_TAG, nationId);
    if (nationType != null) {
        xw.writeAttribute(NATION_TYPE_TAG, nationType);
    }
    xw.writeAttribute(ADMIN_TAG, admin);
    xw.writeAttribute(READY_TAG, ready);
    xw.writeAttribute(DEAD_TAG, dead);
    xw.writeAttribute(PLAYER_TYPE_TAG, playerType);
    xw.writeAttribute(AI_TAG, ai);
    if (xw.validFor(this)) {
        xw.writeAttribute(BANKRUPT_TAG, bankrupt);
        xw.writeAttribute(TAX_TAG, tax);
        xw.writeAttribute(GOLD_TAG, gold);
        xw.writeAttribute(IMMIGRATION_TAG, immigration);
        xw.writeAttribute(LIBERTY_TAG, liberty);
        xw.writeAttribute(INTERVENTION_BELLS_TAG, interventionBells);
        if (currentFather != null) {
            xw.writeAttribute(CURRENT_FATHER_TAG, currentFather);
        }
        xw.writeAttribute(IMMIGRATION_REQUIRED_TAG, immigrationRequired);
        xw.writeAttribute(ATTACKED_BY_PRIVATEERS_TAG, attackedByPrivateers);
        xw.writeAttribute(OLD_SOL_TAG, oldSoL);
        xw.writeAttribute(SCORE_TAG, score);
    }
    if (newLandName != null) {
        xw.writeAttribute(NEW_LAND_NAME_TAG, newLandName);
    }
    if (independentNationName != null) {
        xw.writeAttribute(INDEPENDENT_NATION_NAME_TAG, independentNationName);
    }
    if (entryLocation != null) {
        xw.writeLocationAttribute(ENTRY_LOCATION_TAG, entryLocation);
    }
}