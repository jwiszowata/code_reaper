public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    Settlement settlement = getSettlement();
    if (settlement != null) {
        result = Math.min(result, settlement.checkIntegrity(fix));
    }
    if (tileItemContainer != null) {
        result = Math.min(result, tileItemContainer.checkIntegrity(fix));
    }
    return result;
}