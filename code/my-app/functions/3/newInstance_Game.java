public <T extends FreeColObject> T newInstance(Class<T> returnClass) {
    return newInstance(this, returnClass, false);
}