public Set<String> getImageKeySet(String prefix) {
    return transform(imageResources.keySet(), k -> k.startsWith(prefix), Function.identity(), Collectors.toSet());
}