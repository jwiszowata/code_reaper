public boolean complete(ChangeSet cs) {
    boolean ret;
    synchronized (this) {
        ret = this.completed;
        this.completed = true;
    }
    return ret;
}