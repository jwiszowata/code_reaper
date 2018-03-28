public FreeColXMLReader getClientOptionsFreeColXMLReader() throws IOException {
    return new FreeColXMLReader(getInputStream(CLIENT_OPTIONS));
}