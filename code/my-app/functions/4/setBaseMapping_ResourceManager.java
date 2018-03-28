public static synchronized void setBaseMapping(final ResourceMapping mapping) {
    baseMapping = mapping;
    update(mapping != null);
}