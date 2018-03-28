public final List<FoundingFather> getFathers(Game game) {
    final Specification spec = game.getSpecification();
    return transform(fatherKeys, tid -> hasAttribute(tid), tid -> spec.getFoundingFather(getStringAttribute(tid)));
}