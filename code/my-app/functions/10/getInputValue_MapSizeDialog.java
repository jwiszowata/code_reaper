protected Dimension getInputValue() {
    int width, height;
    try {
        width = Integer.parseInt(inputWidth.getText());
        height = Integer.parseInt(inputHeight.getText());
    } catch (NumberFormatException nfe) {
        return null;
    }
    return (width <= 0 || height <= 0) ? null : new Dimension(width, height);
}