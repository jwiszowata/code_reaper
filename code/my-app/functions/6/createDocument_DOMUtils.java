public static Document createDocument(String tag, Map<String, String> map) {
    Document document = createDocument(tag);
    Element root = document.getDocumentElement();
    forEachMapEntry(map, e -> root.setAttribute(e.getKey(), e.getValue()));
    return document;
}