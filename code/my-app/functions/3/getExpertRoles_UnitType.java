public List<Role> getExpertRoles() {
    return transform(getSpecification().getRoles(), matchKey(this, Role::getExpertUnit));
}