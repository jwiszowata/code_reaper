public void setCapital(boolean capital) {
    if (isCapital() != capital) {
        changeType(owner.getNationType().getSettlementType(capital));
    }
}