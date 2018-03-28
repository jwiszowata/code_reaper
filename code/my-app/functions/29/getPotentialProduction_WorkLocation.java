public int getPotentialProduction(GoodsType goodsType, UnitType unitType) {
    if (!canProduce(goodsType, unitType))
        return 0;
    if (unitType != null) {
        switch(getNoWorkReason()) {
            case NONE:
            case ALREADY_PRESENT:
            case CLAIM_REQUIRED:
                break;
            case CAPACITY_EXCEEDED:
                if (getUnitCapacity() > 0)
                    break;
            case WRONG_TYPE:
            case OWNED_BY_ENEMY:
            case ANOTHER_COLONY:
            case COLONY_CENTER:
            case MISSING_ABILITY:
            case MISSING_SKILL:
            case MINIMUM_SKILL:
            case MAXIMUM_SKILL:
            case OCCUPIED_BY_ENEMY:
            default:
                return 0;
        }
    }
    int amount = getBaseProduction(null, goodsType, unitType);
    amount = (int) applyModifiers(amount, getGame().getTurn(), getProductionModifiers(goodsType, unitType));
    return (amount < 0) ? 0 : amount;
}