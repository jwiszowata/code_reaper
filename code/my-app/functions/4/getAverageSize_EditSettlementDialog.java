private int getAverageSize() {
    SettlementType t = getSettlementType();
    return (t.getMinimumSize() + t.getMaximumSize()) / 2;
}