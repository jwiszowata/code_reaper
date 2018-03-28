public boolean changeRoleCount(int delta) {
    this.roleCount = Math.max(0, this.roleCount + delta);
    if (this.roleCount != 0)
        return false;
    this.role = getSpecification().getDefaultRole();
    return true;
}