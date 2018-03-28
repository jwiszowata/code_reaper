public void setLabelValues(JLabel label, ModOption value) {
    FreeColModFile modFile = value.getValue();
    if (modFile == null) {
        label.setText(value.toString());
    } else {
        ModOptionUI.labelModFile(label, modFile);
    }
}