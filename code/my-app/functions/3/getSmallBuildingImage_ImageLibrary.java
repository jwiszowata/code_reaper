public BufferedImage getSmallBuildingImage(Building building) {
    return getBuildingImage(building.getType(), building.getOwner(), scaleFactor * 0.75f);
}