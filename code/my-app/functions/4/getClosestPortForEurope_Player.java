public Settlement getClosestPortForEurope() {
    final Comparator<Settlement> comp = Comparator.comparingInt(Settlement::getHighSeasCount);
    return minimize(getSettlements(), comp);
}