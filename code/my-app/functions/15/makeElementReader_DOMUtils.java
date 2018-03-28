private static FreeColXMLReader makeElementReader(Element element, boolean intern) throws IOException {
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer xmlTransformer = factory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        xmlTransformer.transform(new DOMSource(element), new StreamResult(stringWriter));
        String xml = stringWriter.toString();
        StringReader sr = new StringReader(xml);
        FreeColXMLReader xr = new FreeColXMLReader(sr);
        xr.setReadScope((intern) ? FreeColXMLReader.ReadScope.NORMAL : FreeColXMLReader.ReadScope.NOINTERN);
        return xr;
    } catch (TransformerException ex) {
        throw new RuntimeException("Reader creation failure", ex);
    }
}