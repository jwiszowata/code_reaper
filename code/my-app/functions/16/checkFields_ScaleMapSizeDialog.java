private void checkFields() {
    try {
        int w = Integer.parseInt(inputWidth.getText());
        if (w <= 0)
            throw new NumberFormatException();
    } catch (NumberFormatException nfe) {
        inputWidth.setText(Integer.toString(oldMap.getWidth()));
    }
    try {
        int h = Integer.parseInt(inputHeight.getText());
        if (h <= 0)
            throw new NumberFormatException();
    } catch (NumberFormatException nfe) {
        inputHeight.setText(Integer.toString(oldMap.getHeight()));
    }
}