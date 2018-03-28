public void disconnect() {
    if (this.connection != null)
        this.connection.close();
    setConnection(null);
}