public Parameters getResponse() {
    Object value = getValue();
    if (options.get(0).equals(value)) {
        checkFields();
        return new Parameters(Integer.parseInt(inputD.getText()), Integer.parseInt(inputM.getText()));
    }
    return null;
}