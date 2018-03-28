public void seeTile() {
    for (Player p : transform(getGame().getLiveEuropeanPlayers(), p -> p.canSee(this))) {
        seeTile(p);
    }
}