public static <T> void forEach(Stream<T> stream, Predicate<? super T> predicate, Consumer<? super T> consumer) {
    if (stream != null && consumer != null) {
        forEach_internal(stream, predicate, consumer);
    }
}