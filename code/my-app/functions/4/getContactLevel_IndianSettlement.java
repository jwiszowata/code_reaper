public ContactLevel getContactLevel(Player player) {
    ContactLevel cl = contactLevels.get(player);
    return (cl == null) ? ContactLevel.UNCONTACTED : cl;
}