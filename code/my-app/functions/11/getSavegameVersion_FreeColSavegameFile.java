public int getSavegameVersion() throws IOException, XMLStreamException {
    List<String> v = this.peekAttributes(versionList);
    int ret = -1;
    if (v != null && v.size() == 1) {
        try {
            ret = Integer.parseInt(v.get(0));
        } catch (NumberFormatException nfe) {
        }
    }
    return ret;
}