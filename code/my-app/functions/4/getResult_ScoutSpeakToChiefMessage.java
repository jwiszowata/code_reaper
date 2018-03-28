public String getResult() {
    String result = getStringAttribute(RESULT_TAG);
    return (result == null) ? "" : result;
}