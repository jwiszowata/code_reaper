private static <T> boolean any_internal(Stream<T> stream, Predicate<? super T> predicate) {
    return stream.anyMatch(predicate);
}