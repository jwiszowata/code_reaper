private void disconnect() {
    askToStop();
    connection.sendDisconnect();
}