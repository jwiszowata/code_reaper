public static Map<String, String> getAttributeMap(Element element) {
    Map<String, String> map = new HashMap<>();
    NamedNodeMap nnm = element.getAttributes();
    final int n = nnm.getLength();
    for (int i = 0; i < n; i++) {
        Node node = nnm.item(i);
        map.put(node.getNodeName(), node.getNodeValue());
    }
    return map;
}