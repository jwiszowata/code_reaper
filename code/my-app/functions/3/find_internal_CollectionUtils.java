private static <T> T find_internal(Stream<T> stream, Predicate<? super T> predicate, T fail) {
    return first_internal(stream.filter(predicate), fail);
}