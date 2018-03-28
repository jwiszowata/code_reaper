public List<RandomChoice<MonarchAction>> getActionChoices() {
    final Specification spec = getSpecification();
    List<RandomChoice<MonarchAction>> choices = new ArrayList<>();
    int dx = 1 + spec.getInteger(GameOptions.MONARCH_MEDDLING);
    int turn = getGame().getTurn().getNumber();
    int grace = (6 - dx) * 10;
    if (turn < grace || !player.hasSettlements() || player.getPlayerType() != PlayerType.COLONIAL) {
        return choices;
    }
    addIfValid(choices, MonarchAction.NO_ACTION, Math.max(200 - turn, 100));
    addIfValid(choices, MonarchAction.RAISE_TAX_ACT, 5 + dx);
    addIfValid(choices, MonarchAction.RAISE_TAX_WAR, 5 + dx);
    addIfValid(choices, MonarchAction.LOWER_TAX_WAR, 5 - dx);
    addIfValid(choices, MonarchAction.LOWER_TAX_OTHER, 5 - dx);
    addIfValid(choices, MonarchAction.ADD_TO_REF, 10 + dx);
    addIfValid(choices, MonarchAction.DECLARE_PEACE, 6 - dx);
    addIfValid(choices, MonarchAction.DECLARE_WAR, 5 + dx);
    if (player.checkGold(MONARCH_MINIMUM_PRICE)) {
        addIfValid(choices, MonarchAction.MONARCH_MERCENARIES, 6 - dx);
    } else if (dx < 3) {
        addIfValid(choices, MonarchAction.SUPPORT_LAND, 3 - dx);
    }
    addIfValid(choices, MonarchAction.SUPPORT_SEA, 6 - dx);
    addIfValid(choices, MonarchAction.HESSIAN_MERCENARIES, 6 - dx);
    return choices;
}