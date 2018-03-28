public static List<Arrangement> readArrangements(Game game, Element element) {
    List<Arrangement> ret = new ArrayList<>();
    int n = getIntegerAttribute(element, FreeColObject.ARRAY_SIZE_TAG, 0);
    for (int i = 0; i < n; i++) {
        ret.add(new Arrangement().readFromElement(game, element, i));
    }
    return ret;
}