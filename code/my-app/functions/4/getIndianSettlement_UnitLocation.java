public final IndianSettlement getIndianSettlement() {
    Settlement settlement = getSettlement();
    return (settlement instanceof IndianSettlement) ? (IndianSettlement) settlement : null;
}