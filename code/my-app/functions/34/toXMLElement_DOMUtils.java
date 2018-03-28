private static Element toXMLElement(FreeColObject fco, Document document, WriteScope writeScope, List<String> fields) {
    StringWriter sw = new StringWriter();
    FreeColXMLWriter xw = null;
    try {
        xw = new FreeColXMLWriter(sw, writeScope);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Error creating FreeColXMLWriter,", ioe);
        return null;
    }
    try {
        if (fields == null) {
            try {
                fco.toXML(xw);
            } catch (XMLStreamException xse) {
                throw new RuntimeException("toXML failed on " + fco, xse);
            }
        } else {
            try {
                fco.toXMLPartial(xw, fields);
            } catch (XMLStreamException xse) {
                throw new RuntimeException("toXML[" + join(",", fields) + "] failed on " + fco, xse);
            }
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document tempDocument = null;
        DocumentBuilder builder = factory.newDocumentBuilder();
        tempDocument = builder.parse(new InputSource(new StringReader(sw.toString())));
        return (Element) document.importNode(tempDocument.getDocumentElement(), true);
    } catch (Exception ex) {
        throw new RuntimeException("Parse fail at " + fco, ex);
    } finally {
        xw.close();
    }
}