public StringTemplate getLabel() {
    StringTemplate label = StringTemplate.key(type);
    if (tileItemContainer != null) {
        List<TileItem> keys = tileItemContainer.getCompleteItems();
        if (!keys.isEmpty()) {
            label = StringTemplate.label("/").addNamed(type);
            for (Named key : keys) label.addNamed(key);
        }
    }
    return label;
}