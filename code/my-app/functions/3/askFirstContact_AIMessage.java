public static boolean askFirstContact(AIPlayer aiPlayer, Player contactor, Player contactee, Tile tile, boolean ack) {
    return aiPlayer.askServer().firstContact(contactor, contactee, tile, ack);
}