public Connection getConnection() {
    return ((DummyConnection) this.player.getConnection()).getOtherConnection();
}