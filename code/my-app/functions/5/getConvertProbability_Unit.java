public float getConvertProbability() {
    final Specification spec = getSpecification();
    int opt = spec.getInteger(GameOptions.NATIVE_CONVERT_PROBABILITY);
    return 0.01f * applyModifiers(opt, getGame().getTurn(), Modifier.NATIVE_CONVERT_BONUS);
}