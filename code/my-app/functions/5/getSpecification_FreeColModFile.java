public Specification getSpecification() throws IOException {
    try (InputStream si = getSpecificationInputStream()) {
        return (si == null) ? null : new Specification(si);
    }
}