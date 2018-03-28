public void setLabelValues(JLabel label, Destination value) {
    if (value.icon != null)
        label.setIcon(value.icon);
    label.setText(value.text);
}