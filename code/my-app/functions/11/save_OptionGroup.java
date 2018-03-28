public boolean save(File file) {
    boolean ret = false;
    try {
        ret = this.save(file, null, true);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Save OptionGroup(" + getId() + ") to " + file.getPath() + " crashed", e);
        return false;
    }
    logger.info("Save OptionGroup(" + getId() + ") to " + file.getPath() + ((ret) ? " succeeded" : " failed"));
    return ret;
}