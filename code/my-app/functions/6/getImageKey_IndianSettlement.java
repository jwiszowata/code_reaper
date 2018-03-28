public String getImageKey() {
    String key = getType().getId();
    if (hasMissionary())
        key += ".mission";
    return "image.tileitem." + key;
}