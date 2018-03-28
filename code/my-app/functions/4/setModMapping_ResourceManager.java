public static synchronized void setModMapping(final ResourceMapping mapping) {
    modMapping = mapping;
    update(mapping != null);
}