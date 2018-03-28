private final void changeType(final SettlementType newType) {
    if (type != null)
        removeFeatures(type);
    setType(newType);
    if (newType != null)
        addFeatures(newType);
}