public static boolean askNationSummary(AIPlayer owner, Player player) {
    return owner.askServer().nationSummary(owner.getPlayer(), player);
}