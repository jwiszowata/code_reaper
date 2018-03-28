public void dropActionChanged(DragSourceDragEvent dsde) {
    DragSourceContext dsc = dsde.getDragSourceContext();
    JComponent comp = (JComponent) dsc.getComponent();
    updatePartialChosen(comp, dsde.getUserAction() == MOVE);
}