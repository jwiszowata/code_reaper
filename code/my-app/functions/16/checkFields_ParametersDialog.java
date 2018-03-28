private void checkFields() {
    try {
        int d = Integer.parseInt(inputD.getText());
        if (d <= 0)
            throw new NumberFormatException();
    } catch (NumberFormatException nfe) {
        inputD.setText(Integer.toString(DEFAULT_distToLandFromHighSeas));
    }
    try {
        int m = Integer.parseInt(inputM.getText());
        if (m <= 0)
            throw new NumberFormatException();
    } catch (NumberFormatException nfe) {
        inputM.setText(Integer.toString(DEFAULT_maxDistanceToEdge));
    }
}