public static BufferedImage getUnitImage(UnitType unitType, Dimension size) {
    String roleId = unitType.getDisplayRoleId();
    String roleQual = (Role.isDefaultRoleId(roleId)) ? "" : "." + Role.getRoleSuffix(roleId);
    String key = "image.unit." + unitType.getId() + roleQual;
    return ResourceManager.getImage(key, size);
}