private JLabel createLeftLabel(String key) {
    JLabel result = Utility.localizedLabel(key);
    result.setBorder(Utility.LEFTCELLBORDER);
    return result;
}