protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    capital = xr.getAttribute(CAPITAL_TAG, capital);
    if (xr.hasAttribute(OLD_MINIMUM_SIZE_TAG)) {
        minimumSize = xr.getAttribute(OLD_MINIMUM_SIZE_TAG, minimumSize);
    } else
        minimumSize = xr.getAttribute(MINIMUM_SIZE_TAG, minimumSize);
    if (xr.hasAttribute(OLD_MAXIMUM_SIZE_TAG)) {
        maximumSize = xr.getAttribute(OLD_MAXIMUM_SIZE_TAG, maximumSize);
    } else
        maximumSize = xr.getAttribute(MAXIMUM_SIZE_TAG, maximumSize);
    if (xr.hasAttribute(OLD_VISIBLE_RADIUS_TAG)) {
        visibleRadius = xr.getAttribute(OLD_VISIBLE_RADIUS_TAG, visibleRadius);
    } else
        visibleRadius = xr.getAttribute(VISIBLE_RADIUS_TAG, visibleRadius);
    if (xr.hasAttribute(OLD_CLAIMABLE_RADIUS_TAG)) {
        claimableRadius = xr.getAttribute(OLD_CLAIMABLE_RADIUS_TAG, claimableRadius);
    } else
        claimableRadius = xr.getAttribute(CLAIMABLE_RADIUS_TAG, claimableRadius);
    if (xr.hasAttribute(OLD_EXTRA_CLAIMABLE_RADIUS_TAG)) {
        extraClaimableRadius = xr.getAttribute(OLD_EXTRA_CLAIMABLE_RADIUS_TAG, extraClaimableRadius);
    } else
        extraClaimableRadius = xr.getAttribute(EXTRA_CLAIMABLE_RADIUS_TAG, extraClaimableRadius);
    if (xr.hasAttribute(OLD_WANDERING_RADIUS_TAG)) {
        wanderingRadius = xr.getAttribute(OLD_WANDERING_RADIUS_TAG, wanderingRadius);
    } else
        wanderingRadius = xr.getAttribute(WANDERING_RADIUS_TAG, wanderingRadius);
    if (xr.hasAttribute(OLD_MINIMUM_GROWTH_TAG)) {
        minimumGrowth = xr.getAttribute(OLD_MINIMUM_GROWTH_TAG, minimumGrowth);
    } else
        minimumGrowth = xr.getAttribute(MINIMUM_GROWTH_TAG, minimumGrowth);
    if (xr.hasAttribute(OLD_MAXIMUM_GROWTH_TAG)) {
        maximumGrowth = xr.getAttribute(OLD_MAXIMUM_GROWTH_TAG, maximumGrowth);
    } else
        maximumGrowth = xr.getAttribute(MAXIMUM_GROWTH_TAG, maximumGrowth);
    if (xr.hasAttribute(OLD_TRADE_BONUS_TAG)) {
        tradeBonus = xr.getAttribute(OLD_TRADE_BONUS_TAG, tradeBonus);
    } else
        tradeBonus = xr.getAttribute(TRADE_BONUS_TAG, tradeBonus);
    if (xr.hasAttribute(OLD_CONVERT_THRESHOLD_TAG)) {
        convertThreshold = xr.getAttribute(OLD_CONVERT_THRESHOLD_TAG, convertThreshold);
    } else
        convertThreshold = xr.getAttribute(CONVERT_THRESHOLD_TAG, convertThreshold);
}