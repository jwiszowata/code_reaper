private String fixRegionKey(String key) {
    if (key == null)
        return key;
    for (String r : predefinedRegionKeys) {
        if (key.equals(r)) {
            return r;
        } else if (key.equals(Messages.nameKey(r))) {
            return lastPart(key, ".");
        }
    }
    return null;
}