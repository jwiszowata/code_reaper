public void reset() {
    File file = getOption().getValue();
    String text = (file == null) ? "" : file.getAbsolutePath();
    fileField.setText(text);
    fileField.setToolTipText(text);
}