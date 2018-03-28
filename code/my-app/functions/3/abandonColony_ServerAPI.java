public boolean abandonColony(Colony colony) {
    return ask(colony.getGame(), new AbandonColonyMessage(colony));
}