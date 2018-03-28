public String serialize(WriteScope scope) throws XMLStreamException {
    StringWriter sw = new StringWriter();
    try (FreeColXMLWriter xw = new FreeColXMLWriter(sw, scope)) {
        this.toXML(xw);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Error creating FreeColXMLWriter,", ioe);
        return null;
    }
    return sw.toString();
}