public List<T> getOptionValues() {
    return transform(value, isNotNull(), o -> o.getValue());
}