public boolean complete(boolean result, ChangeSet cs) {
    boolean ret = super.complete(cs);
    if (!ret) {
        completeInternal(result, cs);
    }
    return ret;
}