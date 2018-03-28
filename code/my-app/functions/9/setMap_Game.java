public void setMap(Map newMap) {
    if (this.map != newMap) {
        for (HighSeas hs : transform(getLivePlayers(), alwaysTrue(), Player::getHighSeas, toListNoNulls())) {
            hs.removeDestination(this.map);
            hs.addDestination(newMap);
        }
    }
    this.map = newMap;
}