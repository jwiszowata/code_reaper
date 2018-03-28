public boolean complete(ChangeSet cs) {
    boolean ret = super.complete(cs);
    if (!ret) {
        completeInternal(null, cs);
    }
    return ret;
}