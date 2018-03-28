private static float applyModifiers_internal(float number, Turn turn, Collection<Modifier> mods) {
    float result = number;
    for (Modifier m : mods) {
        float value = m.getValue(turn);
        if (Float.compare(value, Modifier.UNKNOWN) == 0) {
            return value;
        }
        result = m.apply(result, value);
    }
    return result;
}