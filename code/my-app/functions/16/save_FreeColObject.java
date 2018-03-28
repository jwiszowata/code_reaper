public boolean save(OutputStream out, WriteScope scope, boolean pretty) {
    if (scope == null)
        scope = FreeColXMLWriter.WriteScope.toSave();
    try (FreeColXMLWriter xw = new FreeColXMLWriter(out, scope, pretty)) {
        xw.writeStartDocument("UTF-8", "1.0");
        this.toXML(xw);
        xw.writeEndDocument();
        xw.flush();
        return true;
    } catch (XMLStreamException xse) {
        logger.log(Level.WARNING, "Exception writing object.", xse);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Error creating FreeColXMLWriter.", ioe);
    }
    return false;
}