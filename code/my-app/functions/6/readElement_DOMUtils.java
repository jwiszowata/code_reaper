public static <T extends FreeColObject> T readElement(Game game, Element element, boolean intern) {
    if (element == null)
        return null;
    final Class<T> c = getElementClass(element);
    return (c == null) ? null : readElement(game, element, intern, c);
}