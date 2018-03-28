public IndianSettlement getIndianSettlementByName(String name) {
    return find(getIndianSettlements(), matchKeyEquals(name, IndianSettlement::getName));
}