public static <T> Set<T> makeUnmodifiableSet(T... members) {
    Set<T> tmp = new HashSet<>();
    for (T t : members) tmp.add(t);
    return Collections.<T>unmodifiableSet(tmp);
}