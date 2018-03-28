public static List<String> getArrayAttributes(Element element) {
    List<String> result = new ArrayList<>();
    String key;
    int i = 0;
    for (; ; ) {
        key = FreeColObject.arrayKey(i);
        if (!element.hasAttribute(key))
            break;
        result.add(element.getAttribute(key));
        i++;
    }
    return result;
}