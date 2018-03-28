private List<AbstractOption<T>> getValue() {
    List<AbstractOption<T>> result = new ArrayList<>();
    for (Enumeration<AbstractOption<T>> e = model.elements(); e.hasMoreElements(); ) {
        result.add(e.nextElement());
    }
    return result;
}