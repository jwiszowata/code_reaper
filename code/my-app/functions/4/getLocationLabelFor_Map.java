public StringTemplate getLocationLabelFor(Player player) {
    String name = player.getNewLandName();
    return (name == null) ? getLocationLabel() : StringTemplate.name(name);
}