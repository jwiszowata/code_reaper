public static String getSettlementName(Player player, Random random) {
    requireSettlementNames(player, random);
    final Game game = player.getGame();
    synchronized (settlementNameLock) {
        List<String> names = settlementNames.get(player);
        while (!names.isEmpty()) {
            String name = names.remove(0);
            if (game.getSettlementByName(name) == null)
                return name;
        }
    }
    final String base = getFallbackSettlementName(player);
    int i = player.getSettlementCount() + 1;
    String name = null;
    while (game.getSettlementByName(name = base + i++) != null) ;
    return name;
}