public Map createEmptyMap(int width, int height, LogBuilder lb) {
    recache(false);
    return new TerrainGenerator(game, null, random).createMap(new LandMap(width, height), lb);
}