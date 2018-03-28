public void actionPerformed(ActionEvent ae) {
    if (this.colony.getOwner() == getMyPlayer()) {
        String command = ae.getActionCommand();
        List<BuildableType> buildables = getBuildableTypes(this.buildQueueList);
        BuildableType bt;
        while ((bt = first(buildables)) != null && lockReasons.get(bt) != null) {
            getGUI().showInformationMessage(bt, this.colony.getUnbuildableMessage(bt));
            command = FAIL;
            removeBuildable(buildables.remove(0));
        }
        igc().setBuildQueue(this.colony, buildables);
        if (null != command)
            switch(command) {
                case FAIL:
                    updateAllLists();
                    return;
                case OK:
                    break;
                case BUY:
                    igc().payForBuilding(this.colony);
                    break;
                default:
                    super.actionPerformed(ae);
                    break;
            }
    }
    getGUI().removeFromCanvas(this);
}