public static <T> List<T> toList(Stream<T> stream) {
    return (stream == null) ? Collections.<T>emptyList() : toList_internal(stream);
}