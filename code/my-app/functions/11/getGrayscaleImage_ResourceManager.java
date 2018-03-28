public static BufferedImage getGrayscaleImage(final String key, final float scale) {
    BufferedImage image = getImageResource(key).getGrayscaleImage(scale);
    if (image == null) {
        logger.warning("getGrayscaleImage(" + key + ", " + scale + ") failed");
        image = getImageResource(REPLACEMENT_IMAGE).getGrayscaleImage(scale);
        if (image == null) {
            FreeColClient.fatal("Failed getting replacement image.");
        }
    }
    return image;
}