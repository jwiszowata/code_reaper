public BufferedImage getImage() {
    if (image == null) {
        logger.finest("Preload not ready for " + getResourceLocator());
        preload();
    }
    return image;
}