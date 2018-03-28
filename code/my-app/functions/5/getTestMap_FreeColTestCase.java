public static Map getTestMap(boolean explored) {
    MapBuilder builder = new MapBuilder(getGame());
    builder.setExploredByAll(explored);
    return builder.build();
}