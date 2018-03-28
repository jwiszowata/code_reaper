private static BufferedImage loadImage(URI uri) {
    try {
        URL url = uri.toURL();
        BufferedImage image = ImageIO.read(url);
        if (image != null)
            return image;
        logger.log(Level.WARNING, "Failed to load image from: " + uri);
    } catch (IOException e) {
        logger.log(Level.WARNING, "Failed to load image from: " + uri, e);
    }
    return null;
}