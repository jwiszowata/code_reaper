public List<String> getResponse() {
    Object value = getValue();
    if (options.get(0).equals(value)) {
        List<String> result = new ArrayList<>();
        result.add(this.nationField.getText().replaceAll("[^\\s\\w]", ""));
        result.add(this.countryField.getText());
        return result;
    }
    return null;
}