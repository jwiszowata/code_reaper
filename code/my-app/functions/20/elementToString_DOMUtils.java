public static String elementToString(Element element) {
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer xt = factory.newTransformer();
        StringWriter sw = new StringWriter();
        xt.transform(new DOMSource(element), new StreamResult(sw));
        String result = sw.toString();
        if (result.startsWith("<?xml")) {
            final String xmlEnd = "?>";
            int index = result.indexOf(xmlEnd);
            if (index > 0) {
                result = result.substring(index + xmlEnd.length());
            }
        }
        return result;
    } catch (TransformerException e) {
        logger.log(Level.WARNING, "TransformerException", e);
    }
    return null;
}