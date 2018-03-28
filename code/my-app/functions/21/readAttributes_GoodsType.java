protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    isFarmed = xr.getAttribute(IS_FARMED_TAG, false);
    isFood = xr.getAttribute(IS_FOOD_TAG, false);
    isMilitary = xr.getAttribute(IS_MILITARY_TAG, false);
    ignoreLimit = xr.getAttribute(IGNORE_LIMIT_TAG, false);
    newWorldGoods = xr.getAttribute(NEW_WORLD_GOODS_TAG, false);
    tradeGoods = xr.getAttribute(TRADE_GOODS_TAG, false);
    breedingNumber = xr.getAttribute(BREEDING_NUMBER_TAG, INFINITY);
    price = xr.getAttribute(PRICE_TAG, INFINITY);
    madeFrom = xr.getType(spec, MADE_FROM_TAG, GoodsType.class, (GoodsType) null);
    storable = xr.getAttribute(STORABLE_TAG, true);
    storedAs = xr.getType(spec, STORED_AS_TAG, GoodsType.class, (GoodsType) null);
    productionWeight = xr.getAttribute(PRODUCTION_WEIGHT_TAG, DEFAULT_PRODUCTION_WEIGHT);
    if (!xr.hasAttribute(PRODUCTION_WEIGHT_TAG) && isFarmed) {
        productionWeight = 3.0f;
    }
    lowProductionThreshold = xr.getAttribute(LOW_PRODUCTION_THRESHOLD_TAG, DEFAULT_LOW_PRODUCTION_THRESHOLD);
    zeroProductionFactor = xr.getAttribute(ZERO_PRODUCTION_FACTOR_TAG, DEFAULT_ZERO_PRODUCTION_FACTOR);
}