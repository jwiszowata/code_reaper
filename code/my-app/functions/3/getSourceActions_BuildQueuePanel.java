public int getSourceActions(JComponent comp) {
    return (comp == BuildQueuePanel.this.unitList) ? COPY : MOVE;
}