public void updateOption() {
    File f = (fileField.getText() == null || fileField.getText().isEmpty()) ? null : new File(fileField.getText());
    getOption().setValue(f);
}