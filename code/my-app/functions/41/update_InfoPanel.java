public void update() {
    InfoPanelMode newMode = getMode();
    Player player = getFreeColClient().getMyPlayer();
    boolean fail = newMode == InfoPanelMode.END && player != null && player.hasNextActiveUnit();
    logger.info("InfoPanel " + mode + " -> " + newMode + ((fail) ? "inconsistent" : ""));
    if (this.mode != newMode) {
        switch(this.mode = newMode) {
            case END:
                this.mapEditorPanel.setVisible(false);
                this.tileInfoPanel.setVisible(false);
                this.unitInfoPanel.setVisible(false);
                this.endTurnPanel.setVisible(true);
                break;
            case MAP:
                this.endTurnPanel.setVisible(false);
                this.tileInfoPanel.setVisible(false);
                this.unitInfoPanel.setVisible(false);
                this.mapEditorPanel.setVisible(true);
                break;
            case TILE:
                this.endTurnPanel.setVisible(false);
                this.mapEditorPanel.setVisible(false);
                this.unitInfoPanel.setVisible(false);
                this.tileInfoPanel.setVisible(true);
                break;
            case UNIT:
                this.endTurnPanel.setVisible(false);
                this.mapEditorPanel.setVisible(false);
                this.tileInfoPanel.setVisible(false);
                this.unitInfoPanel.setVisible(true);
                break;
            case NONE:
            default:
                this.endTurnPanel.setVisible(false);
                this.mapEditorPanel.setVisible(false);
                this.tileInfoPanel.setVisible(false);
                this.unitInfoPanel.setVisible(false);
                break;
        }
    }
}