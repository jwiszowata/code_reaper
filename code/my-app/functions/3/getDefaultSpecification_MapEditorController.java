public Specification getDefaultSpecification() throws IOException {
    return FreeCol.loadSpecification(FreeCol.getTCFile(), FreeCol.getAdvantages(), FreeCol.getDifficulty());
}