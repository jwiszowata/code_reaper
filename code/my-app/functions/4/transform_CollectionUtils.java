public static <T> List<T> transform(Stream<T> stream, Predicate<? super T> predicate) {
    final Stream<T> s = (stream == null) ? Stream.<T>empty() : stream;
    return transform_internal(s, predicate, Function.<T>identity(), null, Collectors.toList());
}