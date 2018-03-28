public void clearChildren() {
    Element element = getElement();
    NodeList nl = element.getChildNodes();
    for (int i = nl.getLength() - 1; i >= 0; i--) {
        element.removeChild(nl.item(i));
    }
}