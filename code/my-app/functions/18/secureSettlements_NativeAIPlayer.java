private void secureSettlements(int[] randoms, LogBuilder lb) {
    int randomIdx = 0;
    List<IndianSettlement> settlements = getPlayer().getIndianSettlementList();
    for (IndianSettlement is : settlements) {
        int n = randoms[randomIdx++];
        IndianSettlement settlement = settlements.get(n);
        if (settlement != is) {
            is.tradeGoodsWithSettlement(settlement);
        }
    }
    for (IndianSettlement is : settlements) {
        lb.mark();
        equipBraves(is, lb);
        secureIndianSettlement(is, lb);
        if (lb.grew("\n  At ", is.getName()))
            lb.shrink(", ");
    }
}