public void appendRequiredAbility(StyledDocument doc, String key, boolean value) {
    final Specification spec = getSpecification();
    try {
        doc.insertString(doc.getLength(), Messages.getName(key), doc.getStyle("regular"));
        List<JButton> requiredTypes = transform(spec.getTypesProviding(key, value), alwaysTrue(), t -> {
            JButton typeButton = getButton(t);
            typeButton.addActionListener(this);
            return typeButton;
        });
        JButton rt = first(requiredTypes);
        if (rt != null) {
            doc.insertString(doc.getLength(), " (", doc.getStyle("regular"));
            StyleConstants.setComponent(doc.getStyle("button"), rt);
            doc.insertString(doc.getLength(), " ", doc.getStyle("button"));
            for (int index = 1; index < requiredTypes.size(); index++) {
                JButton button = requiredTypes.get(index);
                doc.insertString(doc.getLength(), " / ", doc.getStyle("regular"));
                StyleConstants.setComponent(doc.getStyle("button"), button);
                doc.insertString(doc.getLength(), " ", doc.getStyle("button"));
            }
            doc.insertString(doc.getLength(), ")", doc.getStyle("regular"));
        }
        doc.insertString(doc.getLength(), "\n", doc.getStyle("regular"));
    } catch (BadLocationException ble) {
        logger.log(Level.WARNING, "Insert fail", ble);
    }
}