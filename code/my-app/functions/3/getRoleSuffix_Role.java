public static String getRoleSuffix(String roleId) {
    return lastPart(roleId, ".");
}