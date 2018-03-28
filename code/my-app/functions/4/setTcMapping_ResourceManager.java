public static synchronized void setTcMapping(final ResourceMapping mapping) {
    tcMapping = mapping;
    update(mapping != null);
}