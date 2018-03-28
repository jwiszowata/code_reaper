protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(CAPITAL_TAG, capital);
    xw.writeAttribute(MINIMUM_SIZE_TAG, minimumSize);
    xw.writeAttribute(MAXIMUM_SIZE_TAG, maximumSize);
    xw.writeAttribute(VISIBLE_RADIUS_TAG, visibleRadius);
    xw.writeAttribute(CLAIMABLE_RADIUS_TAG, claimableRadius);
    xw.writeAttribute(EXTRA_CLAIMABLE_RADIUS_TAG, extraClaimableRadius);
    xw.writeAttribute(WANDERING_RADIUS_TAG, wanderingRadius);
    xw.writeAttribute(MINIMUM_GROWTH_TAG, minimumGrowth);
    xw.writeAttribute(MAXIMUM_GROWTH_TAG, maximumGrowth);
    xw.writeAttribute(TRADE_BONUS_TAG, tradeBonus);
    xw.writeAttribute(CONVERT_THRESHOLD_TAG, convertThreshold);
}