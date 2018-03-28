public final ChooseFoundingFatherMessage setFather(FoundingFather ff) {
    setStringAttribute(FOUNDING_FATHER_TAG, (ff == null) ? null : ff.getId());
    return this;
}