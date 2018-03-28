public StringTemplate getForcesLabel() {
    return StringTemplate.template("model.player.forces").addStringTemplate("%nation%", getNationLabel());
}