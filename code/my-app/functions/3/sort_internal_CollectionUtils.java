private static <T> List<T> sort_internal(Stream<T> stream, Comparator<? super T> comparator) {
    return stream.sorted(comparator).collect(Collectors.toList());
}