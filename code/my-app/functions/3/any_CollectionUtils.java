public static <T> boolean any(Stream<T> stream, Predicate<? super T> predicate) {
    return (stream == null) ? false : any_internal(stream, predicate);
}