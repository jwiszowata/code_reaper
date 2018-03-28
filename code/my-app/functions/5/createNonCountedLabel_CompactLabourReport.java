private JLabel createNonCountedLabel(int otherAmateurs) {
    JLabel label = createNumberLabel(otherAmateurs, "report.labour.notCounted.tooltip");
    label.setForeground(Color.GRAY);
    return label;
}