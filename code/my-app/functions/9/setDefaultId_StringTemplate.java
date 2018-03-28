protected <T extends StringTemplate> T setDefaultId(final String id, Class<T> returnClass) {
    setDefaultId(id);
    try {
        return returnClass.cast(this);
    } catch (ClassCastException cce) {
        logger.log(Level.WARNING, "Invalid class " + this.getClass() + " referenced.", cce);
    }
    return null;
}