public static <T> Stream<T> toStream(Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
}