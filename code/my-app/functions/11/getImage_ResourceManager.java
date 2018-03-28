public static BufferedImage getImage(final String key, final Dimension size) {
    BufferedImage image = getImageResource(key).getImage(size);
    if (image == null) {
        logger.warning("getImage(" + key + ", " + size + ") failed");
        image = getImageResource(REPLACEMENT_IMAGE).getImage(size);
        if (image == null) {
            FreeColClient.fatal("Failed getting replacement image.");
        }
    }
    return image;
}