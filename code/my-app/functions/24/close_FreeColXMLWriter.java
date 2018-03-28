public void close() {
    if (this.xmlStreamWriter != null) {
        try {
            this.xmlStreamWriter.close();
        } catch (XMLStreamException xse) {
            logger.log(Level.WARNING, "Error closing stream.", xse);
        }
    }
    if (this.outputWriter != null) {
        StreamSource source = new StreamSource(new StringReader(this.stringWriter.toString()));
        StreamResult result = new StreamResult(this.outputWriter);
        Transformer transformer = Utils.makeTransformer(true, true);
        try {
            transformer.transform(source, result);
        } catch (TransformerException te) {
            logger.log(Level.WARNING, "Transform fail", te);
        }
        try {
            this.outputWriter.flush();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Flush fail", ioe);
        }
    }
}