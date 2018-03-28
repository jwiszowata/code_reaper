public static void dump(String header, Map<?, ?> map) {
    if (header != null)
        System.err.print(header);
    System.err.print("[ ");
    forEachMapEntry(map, (e) -> {
        System.err.print(e.getKey());
        System.err.print(',');
        System.err.print(e.getValue());
        System.err.print(' ');
    });
    System.err.println(']');
}