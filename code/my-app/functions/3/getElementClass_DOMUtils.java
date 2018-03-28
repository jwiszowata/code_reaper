private static <T extends FreeColObject> Class<T> getElementClass(Element e) {
    return FreeColObject.getFreeColObjectClass(e.getTagName());
}