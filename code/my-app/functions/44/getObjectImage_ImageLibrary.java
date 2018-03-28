public BufferedImage getObjectImage(FreeColObject display, float scale) {
    try {
        final float combinedScale = scaleFactor * scale;
        final Dimension size = scaleDimension(ICON_SIZE, combinedScale);
        BufferedImage image;
        if (display instanceof Goods) {
            display = ((Goods) display).getType();
        } else if (display instanceof Player) {
            display = ((Player) display).getNation();
        }
        if (display instanceof Unit) {
            Unit unit = (Unit) display;
            image = getUnitImage(unit, size);
        } else if (display instanceof UnitType) {
            UnitType unitType = (UnitType) display;
            image = getUnitImage(unitType, size);
        } else if (display instanceof Settlement) {
            Settlement settlement = (Settlement) display;
            image = getSettlementImage(settlement, size);
        } else if (display instanceof LostCityRumour) {
            image = getMiscImage(ImageLibrary.LOST_CITY_RUMOUR, size);
        } else if (display instanceof GoodsType) {
            FreeColSpecObjectType type = (FreeColSpecObjectType) display;
            image = getIconImage(type);
        } else if (display instanceof Nation) {
            FreeColSpecObjectType type = (FreeColSpecObjectType) display;
            image = getMiscIconImage(type, size);
        } else if (display instanceof BuildingType) {
            BuildingType type = (BuildingType) display;
            image = getBuildingImage(type, size);
        } else {
            logger.warning("could not find image of unknown type for " + display);
            return null;
        }
        if (image == null) {
            logger.warning("could not find image for " + display);
            return null;
        }
        return image;
    } catch (Exception e) {
        logger.log(Level.WARNING, "could not find image", e);
        return null;
    }
}