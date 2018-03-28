public void reset(boolean publicServer, boolean singlePlayer) {
    this.singlePlayer.setSelected(false);
    this.privateMultiplayer.setSelected(false);
    this.publicMultiplayer.setSelected(false);
    if (singlePlayer) {
        this.singlePlayer.setSelected(true);
    } else if (publicServer) {
        this.publicMultiplayer.setSelected(true);
    } else {
        this.privateMultiplayer.setSelected(true);
    }
    this.serverNameField.setText("");
}