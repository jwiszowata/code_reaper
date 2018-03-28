public final void setCancelComponent(AbstractButton cancelButton) {
    if (cancelButton == null)
        throw new NullPointerException();
    InputMap inputMap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true), "release");
    Action cancelAction = cancelButton.getAction();
    getActionMap().put("release", cancelAction);
}