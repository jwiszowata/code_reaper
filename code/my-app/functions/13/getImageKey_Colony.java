public String getImageKey() {
    String key;
    if (isUndead()) {
        key = ".undead";
    } else {
        int count = getDisplayUnitCount();
        key = (count <= 3) ? ".small" : (count <= 7) ? ".medium" : ".large";
        String stockade = getStockadeKey();
        if (stockade != null)
            key += "." + stockade;
    }
    return "image.tileitem." + getType().getId() + key;
}