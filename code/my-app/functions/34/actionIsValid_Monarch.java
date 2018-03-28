public boolean actionIsValid(MonarchAction action) {
    initializeCaches();
    switch(action) {
        case NO_ACTION:
            return true;
        case RAISE_TAX_ACT:
        case RAISE_TAX_WAR:
            return player.getTax() < taxMaximum();
        case FORCE_TAX:
            return false;
        case LOWER_TAX_WAR:
        case LOWER_TAX_OTHER:
            return player.getTax() > MINIMUM_TAX_RATE + 10;
        case WAIVE_TAX:
            return true;
        case ADD_TO_REF:
            return !(navalREFUnitTypes.isEmpty() || landREFUnitTypes.isEmpty());
        case DECLARE_PEACE:
            return !collectPotentialFriends().isEmpty();
        case DECLARE_WAR:
            return !collectPotentialEnemies().isEmpty();
        case SUPPORT_SEA:
            return player.getAttackedByPrivateers() && !getSupportSea() && !getDispleasure();
        case SUPPORT_LAND:
        case MONARCH_MERCENARIES:
            return player.isAtWar() && !getDispleasure() && player.hasSettlements();
        case HESSIAN_MERCENARIES:
            return player.checkGold(HESSIAN_MINIMUM_PRICE) && player.hasSettlements();
        case DISPLEASURE:
            return false;
        default:
            throw new IllegalArgumentException("Bogus monarch action: " + action);
    }
}