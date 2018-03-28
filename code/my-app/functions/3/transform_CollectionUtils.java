public static <T> List<T> transform(Collection<T> c, Predicate<? super T> predicate) {
    return transform_internal(c.stream(), predicate, Function.<T>identity(), null, Collectors.toList());
}