public static final String[] getModifierStrings(float value, ModifierType type) {
    String bonus = modifierFormat.format(value);
    if (value == Modifier.UNKNOWN) {
        return new String[] { " ", bonus, null };
    }
    String[] result = (value < 0) ? new String[] { "-", bonus.substring(1), null } : new String[] { "+", bonus, null };
    switch(type) {
        case MULTIPLICATIVE:
            result[0] = "×";
            break;
        case PERCENTAGE:
            result[2] = "%";
            break;
        default:
            break;
    }
    return result;
}