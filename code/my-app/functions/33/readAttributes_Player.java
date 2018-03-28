protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    final Game game = getGame();
    name = xr.getAttribute(USERNAME_TAG, (String) null);
    if (name.startsWith("model.nation."))
        name = Messages.message(name);
    nationId = xr.getAttribute(NATION_ID_TAG, xr.getAttribute(OLD_NATION_ID_TAG, (String) null));
    if (isUnknownEnemy()) {
        nationType = null;
    } else {
        nationType = xr.getType(spec, NATION_TYPE_TAG, NationType.class, (NationType) null);
    }
    admin = xr.getAttribute(ADMIN_TAG, false);
    gold = xr.getAttribute(GOLD_TAG, 0);
    immigration = xr.getAttribute(IMMIGRATION_TAG, 0);
    liberty = xr.getAttribute(LIBERTY_TAG, 0);
    interventionBells = xr.getAttribute(INTERVENTION_BELLS_TAG, 0);
    oldSoL = xr.getAttribute(OLD_SOL_TAG, 0);
    score = xr.getAttribute(SCORE_TAG, 0);
    ready = xr.getAttribute(READY_TAG, false);
    ai = xr.getAttribute(AI_TAG, false);
    dead = xr.getAttribute(DEAD_TAG, false);
    bankrupt = xr.getAttribute(BANKRUPT_TAG, false);
    tax = xr.getAttribute(TAX_TAG, 0);
    changePlayerType(xr.getAttribute(PLAYER_TYPE_TAG, PlayerType.class, (PlayerType) null));
    currentFather = xr.getType(spec, CURRENT_FATHER_TAG, FoundingFather.class, (FoundingFather) null);
    immigrationRequired = xr.getAttribute(IMMIGRATION_REQUIRED_TAG, 12);
    newLandName = xr.getAttribute(NEW_LAND_NAME_TAG, (String) null);
    independentNationName = xr.getAttribute(INDEPENDENT_NATION_NAME_TAG, (String) null);
    attackedByPrivateers = xr.getAttribute(ATTACKED_BY_PRIVATEERS_TAG, false);
    entryLocation = xr.getLocationAttribute(game, ENTRY_LOCATION_TAG, true);
}