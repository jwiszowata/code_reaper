public void readInputStream(InputStream inputStream) throws IOException, SAXException {
    this.document = DOMUtils.readDocument(new InputSource(inputStream));
}