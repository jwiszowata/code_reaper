public void actionPerformed(ActionEvent event) {
    int from = mergeTable.getSelectionModel().getMinSelectionIndex();
    int to = mergeTable.getSelectionModel().getMaxSelectionIndex();
    mergeTableModel.deleteFromRight(from, to);
}