private void enableComponents() {
    NewPanelAction action = Enum.valueOf(NewPanelAction.class, this.buttonGroup.getSelection().getActionCommand());
    switch(action) {
        case SINGLE:
            enableComponents(this.joinComponents, false);
            enableComponents(this.serverComponents, false);
            enableComponents(this.gameComponents, true);
            this.rulesBox.setEnabled(true);
            break;
        case JOIN:
            enableComponents(this.joinComponents, true);
            enableComponents(this.serverComponents, false);
            enableComponents(this.gameComponents, false);
            this.rulesBox.setEnabled(false);
            break;
        case START:
            enableComponents(this.joinComponents, false);
            enableComponents(this.serverComponents, true);
            enableComponents(this.gameComponents, true);
            this.rulesBox.setEnabled(true);
            break;
        case META_SERVER:
            enableComponents(this.joinComponents, false);
            enableComponents(this.serverComponents, false);
            enableComponents(this.gameComponents, false);
            this.rulesBox.setEnabled(false);
            break;
        default:
            break;
    }
}