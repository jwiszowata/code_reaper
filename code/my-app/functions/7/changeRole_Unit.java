public void changeRole(Role role, int roleCount) {
    if (!role.isCompatibleWith(getRole())) {
        setExperience(0);
    }
    setRole(role);
    setRoleCount((role.isDefaultRole()) ? 0 : roleCount);
}