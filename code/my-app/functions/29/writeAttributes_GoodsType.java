protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(IS_FARMED_TAG, isFarmed);
    xw.writeAttribute(IS_FOOD_TAG, isFood);
    xw.writeAttribute(IS_MILITARY_TAG, isMilitary);
    xw.writeAttribute(IGNORE_LIMIT_TAG, ignoreLimit);
    xw.writeAttribute(NEW_WORLD_GOODS_TAG, newWorldGoods);
    xw.writeAttribute(TRADE_GOODS_TAG, tradeGoods);
    xw.writeAttribute(STORABLE_TAG, storable);
    if (breedingNumber != INFINITY) {
        xw.writeAttribute(BREEDING_NUMBER_TAG, breedingNumber);
    }
    if (price != INFINITY) {
        xw.writeAttribute(PRICE_TAG, price);
    }
    if (madeFrom != null) {
        xw.writeAttribute(MADE_FROM_TAG, madeFrom);
    }
    if (storedAs != null) {
        xw.writeAttribute(STORED_AS_TAG, storedAs);
    }
    xw.writeAttribute(PRODUCTION_WEIGHT_TAG, productionWeight);
    if (lowProductionThreshold > DEFAULT_LOW_PRODUCTION_THRESHOLD) {
        xw.writeAttribute(LOW_PRODUCTION_THRESHOLD_TAG, lowProductionThreshold);
    }
    if (0.0 <= zeroProductionFactor && zeroProductionFactor < DEFAULT_ZERO_PRODUCTION_FACTOR) {
        xw.writeAttribute(ZERO_PRODUCTION_FACTOR_TAG, zeroProductionFactor);
    }
}