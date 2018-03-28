protected Transferable createTransferable(JComponent comp) {
    this.source = BuildQueuePanel.this.convertJComp(comp);
    if (this.source == null)
        return null;
    int[] indicesArray = this.source.getSelectedIndices();
    List<? extends BuildableType> buildableTypes = this.source.getSelectedValuesList();
    List<IndexedBuildable> indexedBuildables = new ArrayList<>(indicesArray.length);
    int i = 0;
    for (int index : indicesArray) {
        BuildableType bt = buildableTypes.get(i++);
        indexedBuildables.add(new IndexedBuildable(bt, index));
    }
    return new BuildablesTransferable(indexedBuildables);
}