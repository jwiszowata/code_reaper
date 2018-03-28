public final String getSettlementTypeKey(boolean plural) {
    return getSettlementType(false).getId() + ((plural) ? ".plural" : "");
}