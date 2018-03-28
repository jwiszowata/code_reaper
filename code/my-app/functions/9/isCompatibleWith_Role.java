public static boolean isCompatibleWith(Role role1, Role role2) {
    if (role1 == null) {
        return role2 == null;
    } else if (role2 == null) {
        return false;
    } else {
        return role1 == role2 || role1.getDowngrade() == role2 || role2.getDowngrade() == role1;
    }
}