private static String getFallbackSettlementName(Player player) {
    return Messages.message((player.isEuropean()) ? "nameCache.base.colony" : "nameCache.base.settlement") + "-";
}