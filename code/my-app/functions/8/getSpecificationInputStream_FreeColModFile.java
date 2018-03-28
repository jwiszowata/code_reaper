public InputStream getSpecificationInputStream() throws IOException {
    try {
        return getInputStream(SPECIFICATION_FILE);
    } catch (FileNotFoundException fnfe) {
        ;
    }
    return null;
}