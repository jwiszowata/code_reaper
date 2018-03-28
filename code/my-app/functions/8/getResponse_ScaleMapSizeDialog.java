public Dimension getResponse() {
    Object value = getValue();
    if (options.get(0).equals(value)) {
        checkFields();
        return new Dimension(Integer.parseInt(inputHeight.getText()), Integer.parseInt(inputWidth.getText()));
    }
    return null;
}