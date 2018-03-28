public Settlement getSettlementByName(String name) {
    return (isIndian()) ? getIndianSettlementByName(name) : getColonyByName(name);
}