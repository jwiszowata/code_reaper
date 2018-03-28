public static Document createNewDocument() {
    synchronized (builder) {
        return builder.newDocument();
    }
}