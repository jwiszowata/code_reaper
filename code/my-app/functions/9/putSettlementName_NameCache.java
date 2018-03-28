public static void putSettlementName(Player player, String name) {
    if (!name.startsWith(getFallbackSettlementName(player))) {
        requireSettlementNames(player, null);
        synchronized (settlementNameLock) {
            List<String> names = settlementNames.get(player);
            names.add(name);
        }
    }
}