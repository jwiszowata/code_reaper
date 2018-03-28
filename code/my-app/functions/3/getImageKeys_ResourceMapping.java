public List<String> getImageKeys(String prefix, String suffix) {
    return transform(imageResources.keySet(), k -> k.startsWith(prefix) && k.endsWith(suffix));
}