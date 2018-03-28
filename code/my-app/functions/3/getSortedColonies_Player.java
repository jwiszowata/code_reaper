public List<Colony> getSortedColonies(Comparator<Colony> comp) {
    return transform(getSettlements(), s -> s instanceof Colony, s -> (Colony) s, comp);
}