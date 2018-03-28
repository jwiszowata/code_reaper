public boolean send(ChangeSet cs) {
    return (isConnected()) ? this.connection.sendAndWaitMessage(cs.build(this)) : false;
}