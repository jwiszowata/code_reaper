public GoodsType getExpertProduction() {
    if (summary) {
        return null;
    }
    return getUnitType().getExpertProduction();
}