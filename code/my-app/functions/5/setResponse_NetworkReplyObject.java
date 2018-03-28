public synchronized void setResponse(Object response) {
    this.response = response;
    this.responseGiven = true;
    notify();
}