public static boolean askNewRegionName(AIPlayer aiPlayer, Region region, Tile tile, Unit unit, String name) {
    return aiPlayer.askServer().newRegionName(region, tile, unit, name);
}