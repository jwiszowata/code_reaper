private void updateAllLists() {
    final DefaultListModel<BuildableType> current = (DefaultListModel<BuildableType>) this.buildQueueList.getModel();
    this.featureContainer.clear();
    for (Enumeration<BuildableType> e = current.elements(); e.hasMoreElements(); ) {
        BuildableType type = e.nextElement();
        if (getMinimumIndex(type) >= 0) {
            featureContainer.addFeatures(type);
        } else {
            current.removeElement(type);
        }
    }
    updateBuildingList();
    updateUnitList();
    final boolean pay = getSpecification().getBoolean(GameOptions.PAY_FOR_BUILDING);
    BuildableType bt = (current.getSize() <= 0) ? null : current.getElementAt(0);
    this.buyBuildable.setEnabled(bt != null && pay && this.colony.canPayToFinishBuilding(bt));
    this.setBuyLabel(bt);
    if (current.getSize() > 0) {
        this.constructionPanel.update(current.getElementAt(0));
    } else if (current.getSize() == 0) {
        this.constructionPanel.update();
    }
}