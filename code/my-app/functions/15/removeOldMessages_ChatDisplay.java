public synchronized boolean removeOldMessages() {
    long currentTime = new Date().getTime();
    boolean result = false;
    int i = 0;
    while (i < getMessageCount()) {
        long creationTime = getMessage(i).getCreationTime();
        if ((currentTime - creationTime) >= MESSAGE_AGE) {
            result = true;
            messages.remove(i);
        } else {
            i++;
        }
    }
    return result;
}