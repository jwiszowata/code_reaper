public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + Float.floatToIntBits(value);
    hash = 31 * hash + Float.floatToIntBits(increment);
    hash = 31 * hash + Utils.hashCode(modifierType);
    hash = 31 * hash + Utils.hashCode(incrementType);
    return 31 * hash + modifierIndex;
}