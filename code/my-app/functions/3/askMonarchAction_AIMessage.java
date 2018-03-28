public static boolean askMonarchAction(AIPlayer aiPlayer, MonarchAction action, boolean accept) {
    return aiPlayer.askServer().answerMonarch(aiPlayer.getGame(), action, accept);
}