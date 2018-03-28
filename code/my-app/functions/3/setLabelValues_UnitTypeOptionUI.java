public void setLabelValues(JLabel label, UnitType value) {
    label.setText((value == null) ? Messages.message("none") : Messages.getName(value));
}