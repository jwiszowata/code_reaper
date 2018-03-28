public Stream<Role> getAvailableRoles(List<Role> roles) {
    return getAvailableRolesList(roles).stream();
}