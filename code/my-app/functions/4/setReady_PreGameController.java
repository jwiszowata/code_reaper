public void setReady(boolean ready) {
    getMyPlayer().setReady(ready);
    askServer().setReady(ready);
}