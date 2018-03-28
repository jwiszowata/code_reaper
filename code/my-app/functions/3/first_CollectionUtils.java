public static <T> T first(Stream<T> stream) {
    return (stream == null) ? null : first_internal(stream, null);
}