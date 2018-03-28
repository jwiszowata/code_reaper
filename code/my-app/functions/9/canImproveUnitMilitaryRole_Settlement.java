public Role canImproveUnitMilitaryRole(Unit unit) {
    final Specification spec = getSpecification();
    final Role role = unit.getRole();
    List<Role> military = spec.getMilitaryRolesList();
    int index = military.indexOf(role);
    if (index >= 0)
        military = military.subList(0, index);
    return find(unit.getAvailableRoles(military), r -> canProvideGoods(unit.getGoodsDifference(r, 1)));
}