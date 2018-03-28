public StringTemplate getWaitingLabel() {
    return StringTemplate.template("model.player.waitingFor").addStringTemplate("%nation%", getNationLabel());
}