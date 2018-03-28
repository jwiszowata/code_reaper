private static BufferedImage getRandomizedImage(List<String> keys, String id, Dimension size) {
    int count = keys.size();
    switch(count) {
        case 0:
            return null;
        case 1:
            return ResourceManager.getImage(keys.get(0), size);
        default:
            keys.sort(Comparator.naturalOrder());
            return ResourceManager.getImage(keys.get(Math.abs(id.hashCode() % count)), size);
    }
}