public void actionPerformed(ActionEvent ae) {
    JList<BuildableType> bql = BuildQueuePanel.this.buildQueueList;
    for (BuildableType bt : bql.getSelectedValuesList()) {
        removeBuildable(bt);
    }
    updateAllLists();
}