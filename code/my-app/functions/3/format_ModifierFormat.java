public static final String format(double value) {
    return (value == Modifier.UNKNOWN) ? getUnknownValue() : modifierFormat.format(value);
}