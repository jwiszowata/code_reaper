public List<AbstractGoods> getGoodsDifference(Role role, int roleCount) {
    return Role.getGoodsDifference(getRole(), getRoleCount(), role, roleCount);
}