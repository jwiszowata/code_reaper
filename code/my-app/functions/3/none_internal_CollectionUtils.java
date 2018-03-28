private static <T> boolean none_internal(Stream<T> stream, Predicate<? super T> predicate) {
    return stream.noneMatch(predicate);
}