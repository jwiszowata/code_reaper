public List<IndianSettlement> getIndianSettlementList() {
    return transform(getSettlements(), s -> s instanceof IndianSettlement, s -> (IndianSettlement) s);
}