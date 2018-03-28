public void setLabelValues(JLabel c, T value) {
    c.setText(Messages.message(prefix + value.toString()));
}