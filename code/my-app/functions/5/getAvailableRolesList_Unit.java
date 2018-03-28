public List<Role> getAvailableRolesList(List<Role> roles) {
    if (roles == null)
        roles = getSpecification().getRolesList();
    return transform(roles, r -> roleIsAvailable(r));
}