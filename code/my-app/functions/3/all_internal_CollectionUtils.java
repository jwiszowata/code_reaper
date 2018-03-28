private static <T> boolean all_internal(Stream<T> stream, Predicate<? super T> predicate) {
    return stream.allMatch(predicate);
}