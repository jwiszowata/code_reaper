private boolean load(FreeColSavegameFile save) {
    if (save == null)
        return false;
    boolean ret = false;
    try (FreeColXMLReader xr = save.getClientOptionsFreeColXMLReader()) {
        ret = load(xr);
    } catch (IOException | XMLStreamException ex) {
        logger.log(Level.WARNING, "Load OptionGroup(" + getId() + ") from file " + save.getPath() + " crashed", ex);
        return false;
    }
    logger.info("Load OptionGroup(" + getId() + ") from " + save.getPath() + ((ret) ? " succeeded" : " failed"));
    return ret;
}