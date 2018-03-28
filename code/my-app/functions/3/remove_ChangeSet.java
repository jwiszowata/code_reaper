public void remove(FreeColGameObject fcgo) {
    removeInPlace(changes, c -> c.matches(fcgo));
}