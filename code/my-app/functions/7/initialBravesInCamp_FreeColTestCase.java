public IndianSettlementBuilder initialBravesInCamp(int nBraves) {
    if (nBraves <= 0) {
        throw new IllegalArgumentException("Number of braves must be positive");
    }
    this.initialBravesInCamp = nBraves;
    return this;
}