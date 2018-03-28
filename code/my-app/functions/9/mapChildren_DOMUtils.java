public static <T> List<T> mapChildren(Element element, Function<? super Element, ? extends T> mapper) {
    List<T> ret = new ArrayList<>();
    for (Element e : getChildElementList(element)) {
        T x = mapper.apply(e);
        if (x != null)
            ret.add(x);
    }
    return ret;
}