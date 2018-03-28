private StringWriter elementToStringWriter(Transformer transformer, Element element) {
    StringWriter sw = new StringWriter(BUFFER_SIZE);
    DOMSource source = new DOMSource(element);
    try {
        transformer.transform(source, new StreamResult(sw));
        sw.append(END_OF_STREAM);
    } catch (Exception ex) {
        logger.log(Level.WARNING, "Failed to transform element", ex);
        sw = null;
    }
    return sw;
}