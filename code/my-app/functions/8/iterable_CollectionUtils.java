public static <T> Iterable<T> iterable(final Stream<T> stream) {
    return new Iterable<T>() {

        public Iterator<T> iterator() {
            return stream.iterator();
        }
    };
}