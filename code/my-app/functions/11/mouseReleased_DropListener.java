public void mouseReleased(MouseEvent e) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable clipData = clipboard.getContents(clipboard);
    if (clipData != null) {
        if (clipData.isDataFlavorSupported(DefaultTransferHandler.flavor)) {
            JComponent comp = (JComponent) e.getSource();
            TransferHandler handler = comp.getTransferHandler();
            handler.importData(comp, clipData);
        }
    }
}