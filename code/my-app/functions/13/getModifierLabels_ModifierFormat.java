public static JLabel[] getModifierLabels(Modifier modifier, FreeColSpecObjectType fcgot, Turn turn) {
    String sourceName = getSourceName(modifier.getSource());
    if (fcgot != null && modifier.appliesTo(fcgot)) {
        sourceName += " (" + Messages.getName(fcgot) + ")";
    }
    float value = modifier.getValue(turn);
    String[] bonus = getModifierStrings(value, modifier.getType());
    JLabel[] result = new JLabel[3];
    result[0] = new JLabel(sourceName);
    result[1] = new JLabel(bonus[0] + bonus[1]);
    result[2] = (bonus[2] == null) ? null : new JLabel(bonus[2]);
    return result;
}