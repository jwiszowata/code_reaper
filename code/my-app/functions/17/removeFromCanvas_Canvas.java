public void removeFromCanvas(Component comp) {
    if (comp == null)
        return;
    final Rectangle updateBounds = comp.getBounds();
    final JInternalFrame frame = getInternalFrame(comp);
    notifyClose(comp, frame);
    if (frame != null && frame != comp) {
        frame.dispose();
    } else {
        try {
            super.remove(comp);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Java crash", e);
        }
    }
    repaint(updateBounds.x, updateBounds.y, updateBounds.width, updateBounds.height);
}