public Transferable createTransferable(JComponent comp) {
    if (comp instanceof JLabel && comp instanceof Draggable) {
        return new ImageSelection((JLabel) comp);
    } else {
        return null;
    }
}