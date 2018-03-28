private static <T> int count_internal(Stream<T> stream, Predicate<? super T> predicate) {
    return (int) stream.filter(predicate).count();
}