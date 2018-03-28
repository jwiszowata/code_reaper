public static <T> List<T> makeUnmodifiableList(T... members) {
    List<T> tmp = new ArrayList<>();
    for (T t : members) tmp.add(t);
    return Collections.<T>unmodifiableList(tmp);
}