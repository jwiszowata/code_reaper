public String currentTag() {
    StringBuilder sb = new StringBuilder(getLocalName());
    sb.append(", attributes:");
    int n = getAttributeCount();
    for (int i = 0; i < n; i++) {
        sb.append(' ').append(getAttributeLocalName(i)).append("=\"").append(getAttributeValue(i)).append('"');
    }
    return sb.toString();
}