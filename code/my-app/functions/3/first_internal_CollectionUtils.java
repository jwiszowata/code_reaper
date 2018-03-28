private static <T> T first_internal(Stream<T> stream, T fail) {
    return stream.findFirst().orElse(fail);
}