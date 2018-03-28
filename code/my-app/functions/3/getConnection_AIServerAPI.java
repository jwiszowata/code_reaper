public Connection getConnection() {
    return (this.owner == null) ? null : this.owner.getConnection();
}