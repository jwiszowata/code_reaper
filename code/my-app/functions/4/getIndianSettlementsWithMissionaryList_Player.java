public List<IndianSettlement> getIndianSettlementsWithMissionaryList(Player p) {
    final Predicate<Settlement> isPred = s -> s instanceof IndianSettlement && ((IndianSettlement) s).hasMissionary(p);
    return transform(getSettlements(), isPred, s -> (IndianSettlement) s);
}