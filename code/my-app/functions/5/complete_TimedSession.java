public boolean complete(ChangeSet cs) {
    boolean ret = super.complete(cs);
    cancel();
    return ret;
}