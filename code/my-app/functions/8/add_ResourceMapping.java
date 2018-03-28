public boolean add(String key, ImageResource value) {
    if (!key.startsWith("image.")) {
        logger.warning("Rejecting malformed resource key: " + key);
        return false;
    }
    imageResources.put(key, value);
    return true;
}