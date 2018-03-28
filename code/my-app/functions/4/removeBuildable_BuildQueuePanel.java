private void removeBuildable(Object type) {
    DefaultListModel<BuildableType> model = (DefaultListModel<BuildableType>) this.buildQueueList.getModel();
    model.removeElement(type);
}