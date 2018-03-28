public boolean claimTile(Tile tile, FreeColGameObject claimant, int price) {
    return ask(tile.getGame(), new ClaimLandMessage(tile, claimant, price));
}