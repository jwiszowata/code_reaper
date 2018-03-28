private JLabel createNumberLabel(int value, boolean alwaysAddSign) {
    JLabel result = new JLabel(String.valueOf(value), JLabel.TRAILING);
    result.setBorder(Utility.CELLBORDER);
    if (value < 0) {
        result.setForeground(Color.RED);
    } else if (alwaysAddSign && value > 0) {
        result.setText("+" + value);
    }
    return result;
}