public static BufferedImage getBuildingImage(BuildingType buildingType, Dimension size) {
    return ResourceManager.getImage("image.buildingicon." + buildingType.getId(), size);
}