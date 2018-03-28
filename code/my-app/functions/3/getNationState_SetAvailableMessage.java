public NationState getNationState() {
    return Enum.valueOf(NationState.class, getStringAttribute(STATE_TAG));
}