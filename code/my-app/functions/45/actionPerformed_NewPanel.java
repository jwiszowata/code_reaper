public void actionPerformed(ActionEvent ae) {
    final ConnectController cc = getFreeColClient().getConnectController();
    final SwingGUI gui = getGUI();
    final String command = ae.getActionCommand();
    switch(Enum.valueOf(NewPanelAction.class, command)) {
        case OK:
            FreeCol.setName(getSelectedName());
            FreeCol.setAdvantages(getSelectedAdvantages());
            FreeCol.setTC(getSelectedTC().getId());
            NewPanelAction action = Enum.valueOf(NewPanelAction.class, buttonGroup.getSelection().getActionCommand());
            switch(action) {
                case SINGLE:
                    this.specification.prepare(getSelectedAdvantages(), this.difficulty);
                    if (cc.startSinglePlayerGame(this.specification))
                        return;
                    break;
                case JOIN:
                    int joinPort = getSelectedPort(this.joinPortField);
                    if (joinPort < 0)
                        break;
                    if (cc.joinMultiplayerGame(this.joinNameField.getText(), joinPort))
                        return;
                    break;
                case START:
                    int serverPort = getSelectedPort(this.serverPortField);
                    if (serverPort < 0)
                        break;
                    this.specification.prepare(getSelectedAdvantages(), this.difficulty);
                    if (cc.startMultiplayerGame(this.specification, this.publicServer.isSelected(), serverPort))
                        return;
                    break;
                case META_SERVER:
                    List<ServerInfo> servers = MetaServerUtils.getServerList();
                    if (servers != null)
                        gui.showServerListPanel(servers);
                    break;
                default:
                    break;
            }
            break;
        default:
            super.actionPerformed(ae);
            break;
    }
}