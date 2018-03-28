public String getDisplayRoleId() {
    Role r = first(getExpertRoles());
    return (r != null) ? r.getId() : Specification.DEFAULT_ROLE_ID;
}