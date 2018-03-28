public static Element createElement(String tag, Map<String, String> map) {
    return createDocument(tag, map).getDocumentElement();
}