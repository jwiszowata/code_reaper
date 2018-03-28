protected boolean appliesTo(final FreeColSpecObjectType objectType, final Turn turn) {
    return appliesTo(turn) && appliesTo(objectType);
}