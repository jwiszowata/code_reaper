private static void dump_internal(String header, Stream<?> stream) {
    if (header != null)
        System.err.print(header);
    System.err.print("[ ");
    forEach(stream, (v) -> {
        System.err.print(v);
        System.err.print(' ');
    });
    System.err.println(']');
}