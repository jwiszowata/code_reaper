private static List<Element> getChildElementList(Element element) {
    List<Element> ret = new ArrayList<>();
    NodeList nl = element.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
        if (nl.item(i) instanceof Element)
            ret.add((Element) nl.item(i));
    }
    return ret;
}