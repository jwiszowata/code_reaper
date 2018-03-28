public StringTemplate getLocationLabelFor(Player player) {
    final String name = getName();
    return StringTemplate.name((name == null) ? "?" : name);
}