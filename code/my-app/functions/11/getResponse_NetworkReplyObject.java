public synchronized Object getResponse() {
    if (response == null) {
        try {
            while (!responseGiven) {
                wait();
            }
        } catch (InterruptedException ie) {
        }
    }
    return response;
}