public static boolean askClaimLand(Tile tile, AIUnit aiUnit, int price) {
    return aiUnit.getAIOwner().askServer().claimTile(tile, aiUnit.getUnit(), price);
}