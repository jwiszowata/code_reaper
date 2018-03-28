public static String getCapitalName(Player player, Random random) {
    requireSettlementNames(player, random);
    synchronized (settlementNameLock) {
        return capitalNames.get(player);
    }
}