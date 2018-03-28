private void displayResourceTileItem(Graphics2D g, Resource item) {
    BufferedImage bonusImage = lib.getMiscImage("image.tileitem." + item.getType().getId());
    displayCenteredImage(g, bonusImage);
}