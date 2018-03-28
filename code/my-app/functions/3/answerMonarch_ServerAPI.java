public boolean answerMonarch(Game game, MonarchAction action, boolean accept) {
    return ask(game, new MonarchActionMessage(action, null, "").setResult(accept));
}