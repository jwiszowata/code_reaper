public boolean load(File file) {
    if (file == null)
        return false;
    boolean ret = false;
    try (FreeColXMLReader xr = new FreeColXMLReader(file)) {
        ret = load(xr);
    } catch (IOException | XMLStreamException ex) {
        logger.log(Level.WARNING, "Load OptionGroup(" + getId() + ") from file " + file.getPath() + " crashed", ex);
        return false;
    }
    logger.info("Load OptionGroup(" + getId() + ") from " + file.getPath() + ((ret) ? " succeeded" : " failed"));
    return ret;
}