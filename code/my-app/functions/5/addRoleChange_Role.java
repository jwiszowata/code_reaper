public void addRoleChange(String from, String capture) {
    if (roleChanges == null)
        roleChanges = new ArrayList<>();
    roleChanges.add(new RoleChange(from, capture));
}