public Stance getStance() {
    return Enum.valueOf(Stance.class, getStringAttribute(STANCE_TAG));
}