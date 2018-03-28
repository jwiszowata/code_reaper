public <T extends FreeColObject> T unserialize(String xml, Class<T> returnClass) throws XMLStreamException {
    try {
        FreeColXMLReader xr = new FreeColXMLReader(new StringReader(xml));
        xr.nextTag();
        T ret = newInstance(returnClass);
        ret.readFromXML(xr);
        return ret;
    } catch (Exception ex) {
        throw new XMLStreamException(ex);
    }
}