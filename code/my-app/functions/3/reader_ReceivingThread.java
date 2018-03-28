private DOMMessage reader(BufferedInputStream bis) throws IOException, SAXException {
    return new DOMMessage(bis);
}