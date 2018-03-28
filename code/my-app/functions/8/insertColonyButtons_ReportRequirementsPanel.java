private void insertColonyButtons(StyledDocument doc, List<Colony> colonies) throws Exception {
    for (Colony colony : colonies) {
        StyleConstants.setComponent(doc.getStyle("button"), createColonyButton(colony, false));
        doc.insertString(doc.getLength(), " ", doc.getStyle("button"));
        doc.insertString(doc.getLength(), ", ", doc.getStyle("regular"));
    }
    doc.remove(doc.getLength() - 2, 2);
}