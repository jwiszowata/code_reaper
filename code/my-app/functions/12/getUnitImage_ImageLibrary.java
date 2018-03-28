public static BufferedImage getUnitImage(UnitType unitType, String roleId, boolean nativeEthnicity, Dimension size) {
    if (unitType.hasAbility(Ability.BORN_IN_INDIAN_SETTLEMENT)) {
        nativeEthnicity = false;
    }
    String roleQual = (Role.isDefaultRoleId(roleId)) ? "" : "." + Role.getRoleSuffix(roleId);
    String key = "image.unit." + unitType.getId() + roleQual + ((nativeEthnicity) ? ".native" : "");
    if (!ResourceManager.hasImageResource(key) && nativeEthnicity) {
        key = "image.unit." + unitType.getId() + roleQual;
    }
    BufferedImage image = ResourceManager.getImage(key, size);
    return image;
}