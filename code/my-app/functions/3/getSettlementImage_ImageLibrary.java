public static BufferedImage getSettlementImage(SettlementType settlementType, float scale) {
    return ResourceManager.getImage("image.tileitem." + settlementType.getId(), scale);
}