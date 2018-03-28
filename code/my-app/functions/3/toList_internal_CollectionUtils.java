private static <T> List<T> toList_internal(Stream<T> stream) {
    return stream.collect(Collectors.toList());
}