public void exportAsDrag(JComponent comp, InputEvent e, int action) {
    int srcActions = getSourceActions(comp);
    int dragAction = srcActions & action;
    if (!(e instanceof MouseEvent)) {
        dragAction = NONE;
    }
    if (dragAction != NONE) {
        if (recognizer == null) {
            recognizer = new FreeColDragGestureRecognizer(new FreeColDragHandler());
        }
        recognizer.gestured(comp, (MouseEvent) e, srcActions, dragAction);
    } else {
        exportDone(comp, null, NONE);
    }
}