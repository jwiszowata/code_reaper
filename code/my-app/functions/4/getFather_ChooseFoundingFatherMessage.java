public final FoundingFather getFather(Game game) {
    String id = getStringAttribute(FOUNDING_FATHER_TAG);
    return (id == null) ? null : game.getSpecification().getFoundingFather(id);
}