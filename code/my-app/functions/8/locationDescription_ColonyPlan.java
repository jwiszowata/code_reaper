private String locationDescription(Location loc) {
    String name = colony.getName() + "-";
    String desc = loc.toShortString();
    if (desc.startsWith(name)) {
        desc = desc.substring(name.length(), desc.length());
    }
    return desc;
}