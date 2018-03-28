public static <T extends FreeColObject> T getChild(Game game, Element element, int index, Class<T> returnClass) {
    return DOMUtils.getChild(game, element, index, returnClass);
}