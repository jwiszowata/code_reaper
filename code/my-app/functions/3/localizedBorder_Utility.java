public static TitledBorder localizedBorder(String key, Color color) {
    return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color, 1), Messages.message(key));
}