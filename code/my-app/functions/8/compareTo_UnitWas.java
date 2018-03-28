public int compareTo(UnitWas uw) {
    List<Role> roles = this.unit.getAvailableRolesList(null);
    int cmp = ((UnitLocation) uw.loc).getUnitCapacity() - ((UnitLocation) this.loc).getUnitCapacity();
    if (cmp == 0) {
        cmp = roles.indexOf(this.role) - roles.indexOf(uw.role);
    }
    return cmp;
}