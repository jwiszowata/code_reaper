public static BufferedImage getBuildingImage(BuildingType buildingType, Player player, float scale) {
    String key = "image.buildingicon." + buildingType.getId() + "." + player.getNationResourceKey();
    if (!ResourceManager.hasImageResource(key)) {
        key = "image.buildingicon." + buildingType.getId();
    }
    return ResourceManager.getImage(key, scale);
}