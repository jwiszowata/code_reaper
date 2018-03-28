public List<String> peekAttributes(List<String> attributes) throws IOException, XMLStreamException {
    final FreeColXMLReader xr = this.getSavedGameFreeColXMLReader();
    xr.nextTag();
    List<String> ret = transform(attributes, alwaysTrue(), a -> xr.getAttribute(a, (String) null));
    xr.close();
    return ret;
}