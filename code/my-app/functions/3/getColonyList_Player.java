public List<Colony> getColonyList() {
    return transform(getSettlements(), s -> s instanceof Colony, s -> (Colony) s);
}