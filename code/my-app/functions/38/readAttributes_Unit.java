protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    final Game game = getGame();
    name = xr.getAttribute(NAME_TAG, (String) null);
    Player oldOwner = owner;
    owner = xr.findFreeColGameObject(game, OWNER_TAG, Player.class, (Player) null, true);
    if (xr.shouldIntern())
        game.checkOwners(this, oldOwner);
    UnitType oldUnitType = unitType;
    unitType = xr.getType(spec, UNIT_TYPE_TAG, UnitType.class, (UnitType) null);
    state = xr.getAttribute(STATE_TAG, UnitState.class, UnitState.ACTIVE);
    role = xr.getType(spec, ROLE_TAG, Role.class, spec.getDefaultRole());
    roleCount = xr.getAttribute(ROLE_COUNT_TAG, role.getMaximumCount());
    setLocationNoUpdate(xr.getLocationAttribute(game, LOCATION_TAG, true));
    entryLocation = xr.getLocationAttribute(game, ENTRY_LOCATION_TAG, true);
    movesLeft = xr.getAttribute(MOVES_LEFT_TAG, 0);
    workLeft = xr.getAttribute(WORK_LEFT_TAG, 0);
    attrition = xr.getAttribute(ATTRITION_TAG, 0);
    nationality = xr.getAttribute(NATIONALITY_TAG, (String) null);
    ethnicity = xr.getAttribute(ETHNICITY_TAG, (String) null);
    turnsOfTraining = xr.getAttribute(TURNS_OF_TRAINING_TAG, 0);
    hitPoints = xr.getAttribute(HIT_POINTS_TAG, -1);
    teacher = xr.makeFreeColObject(game, TEACHER_TAG, Unit.class, false);
    student = xr.makeFreeColObject(game, STUDENT_TAG, Unit.class, false);
    setHomeIndianSettlement(xr.makeFreeColObject(game, INDIAN_SETTLEMENT_TAG, IndianSettlement.class, false));
    treasureAmount = xr.getAttribute(TREASURE_AMOUNT_TAG, 0);
    destination = xr.getLocationAttribute(game, DESTINATION_TAG, true);
    tradeRoute = xr.findFreeColGameObject(game, TRADE_ROUTE_TAG, TradeRoute.class, (TradeRoute) null, false);
    currentStop = (tradeRoute == null) ? -1 : xr.getAttribute(CURRENT_STOP_TAG, 0);
    experienceType = xr.getType(spec, EXPERIENCE_TYPE_TAG, GoodsType.class, (GoodsType) null);
    if (experienceType == null && workType != null) {
        experienceType = workType;
    }
    experience = xr.getAttribute(EXPERIENCE_TAG, 0);
    visibleGoodsCount = xr.getAttribute(VISIBLE_GOODS_COUNT_TAG, -1);
    changeWorkType(xr.getType(spec, WORK_TYPE_TAG, GoodsType.class, null));
}