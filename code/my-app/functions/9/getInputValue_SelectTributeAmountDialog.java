protected Integer getInputValue() {
    int result;
    try {
        result = Integer.parseInt(input.getText());
    } catch (NumberFormatException nfe) {
        return null;
    }
    return (result <= 0 || result > maximum) ? null : result;
}