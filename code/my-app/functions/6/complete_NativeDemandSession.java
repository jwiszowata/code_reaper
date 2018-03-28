public boolean complete(ChangeSet cs) {
    boolean ret = super.complete(cs);
    if (!ret)
        completeInternal(false, cs);
    return ret;
}