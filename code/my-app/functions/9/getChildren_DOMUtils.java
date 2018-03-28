public static List<FreeColObject> getChildren(Game game, Element element) {
    List<FreeColObject> ret = new ArrayList<>();
    for (Element e : getChildElementList(element)) {
        FreeColObject fco = readElement(game, e, true);
        if (fco != null)
            ret.add(fco);
    }
    return ret;
}