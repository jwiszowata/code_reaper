protected void exportDone(JComponent source, Transferable data, int action) {
    try {
        if (source instanceof JList && action == MOVE) {
            JList stopList = (JList) source;
            DefaultListModel listModel = (DefaultListModel) stopList.getModel();
            for (Object o : (List) data.getTransferData(STOP_FLAVOR)) {
                listModel.removeElement(o);
            }
        }
    } catch (Exception e) {
        logger.warning(e.toString());
    }
}