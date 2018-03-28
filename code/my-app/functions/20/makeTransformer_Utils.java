public static Transformer makeTransformer(boolean declaration, boolean indent) {
    Transformer tf = null;
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute("indent-number", new Integer(2));
        tf = factory.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        if (!declaration) {
            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        }
        if (indent) {
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        }
    } catch (TransformerException e) {
        logger.log(Level.WARNING, "Failed to install transformer!", e);
    }
    return tf;
}