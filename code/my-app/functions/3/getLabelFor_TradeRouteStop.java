public StringTemplate getLabelFor(String key, Player player) {
    return StringTemplate.template(key).addStringTemplate("%location%", this.getLocation().getLocationLabelFor(player));
}