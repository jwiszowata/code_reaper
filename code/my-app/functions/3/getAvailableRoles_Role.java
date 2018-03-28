public static List<Role> getAvailableRoles(Player player, UnitType type, List<Role> roles) {
    return transform(roles, r -> r.isAvailableTo(player, type));
}