public static <T extends FreeColObject> T getChild(Game game, Element element, int index) {
    Element e = getChildElement(element, index);
    return (e == null) ? null : readElement(game, e, true);
}