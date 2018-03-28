public boolean firstContact(Player player, Player other, Tile tile, boolean result) {
    return ask(player.getGame(), new FirstContactMessage(player, other, tile).setResult(result));
}