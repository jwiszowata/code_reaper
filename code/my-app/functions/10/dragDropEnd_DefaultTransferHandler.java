public void dragDropEnd(DragSourceDropEvent dsde) {
    DragSourceContext dsc = dsde.getDragSourceContext();
    JComponent c = (JComponent) dsc.getComponent();
    if (dsde.getDropSuccess()) {
        ((DefaultTransferHandler) c.getTransferHandler()).exportDone(c, dsc.getTransferable(), dsde.getDropAction());
    } else {
        ((DefaultTransferHandler) c.getTransferHandler()).exportDone(c, null, NONE);
    }
    c.setAutoscrolls(scrolls);
}