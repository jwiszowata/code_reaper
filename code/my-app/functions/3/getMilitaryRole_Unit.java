public Role getMilitaryRole() {
    return first(transform(getSpecification().getMilitaryRoles(), r -> roleIsAvailable(r)));
}