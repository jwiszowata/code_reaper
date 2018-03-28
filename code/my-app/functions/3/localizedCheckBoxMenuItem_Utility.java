public static JCheckBoxMenuItem localizedCheckBoxMenuItem(String key, boolean value) {
    return new JCheckBoxMenuItem(Messages.message(key), value);
}