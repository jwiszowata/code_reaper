public Map createEmptyMap(Game game, int width, int height) {
    return getMapGenerator().createEmptyMap(width, height, new LogBuilder(-1));
}