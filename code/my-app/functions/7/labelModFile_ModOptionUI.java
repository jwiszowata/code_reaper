private static void labelModFile(JLabel label, FreeColModFile modFile) {
    String key = "mod." + modFile.getId();
    label.setText(Messages.getName(key));
    if (Messages.containsKey(Messages.shortDescriptionKey(key))) {
        label.setToolTipText(Messages.getShortDescription(key));
    }
}