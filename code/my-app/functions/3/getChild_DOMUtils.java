public static <T extends FreeColObject> T getChild(Game game, Element element, int index, Class<T> returnClass) {
    return getChild(game, element, index, true, returnClass);
}