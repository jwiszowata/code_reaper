public Map<String, Resource> getResources() {
    HashMap<String, Resource> result = new HashMap<>();
    result.putAll(colorResources);
    result.putAll(fontResources);
    result.putAll(stringResources);
    result.putAll(fafResources);
    result.putAll(szaResources);
    result.putAll(audioResources);
    result.putAll(videoResources);
    result.putAll(imageResources);
    return result;
}