protected void readModDescriptor() throws IOException {
    try (FreeColXMLReader xr = new FreeColXMLReader(getModDescriptorInputStream())) {
        xr.nextTag();
        id = xr.readId();
        parent = xr.getAttribute("parent", (String) null);
    } catch (XMLStreamException xse) {
        throw new IOException(xse);
    }
}