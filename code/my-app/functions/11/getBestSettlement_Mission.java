protected static Settlement getBestSettlement(Player player) {
    final Comparator<Settlement> comp = cachingIntComparator(s -> {
        int value = s.getUnitCount() + s.getTile().getUnitCount();
        if (s instanceof Colony) {
            Colony colony = (Colony) s;
            value += ((colony.isConnectedPort()) ? 10 : 0) + colony.getAvailableWorkLocationsList().size();
        }
        return value;
    });
    return maximize(player.getSettlements(), comp);
}