public final Colony getColony() {
    Settlement settlement = getSettlement();
    return (settlement instanceof Colony) ? (Colony) settlement : null;
}