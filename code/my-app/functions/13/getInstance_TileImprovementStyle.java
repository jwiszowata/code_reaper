public static TileImprovementStyle getInstance(String key) {
    if (key == null || (key.length() != 4 && key.length() != 8))
        return null;
    TileImprovementStyle result = cache.get(key);
    if (result == null) {
        result = new TileImprovementStyle(key);
        cache.put(key, result);
        if (!result.getString().equals(key)) {
            cache.put(result.getString(), result);
        }
    }
    return result;
}