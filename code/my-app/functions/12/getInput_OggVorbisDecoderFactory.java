private String getInput() {
    int count = -1;
    try {
        int idx = oggSyncState.buffer(BUFSIZ);
        count = inputStream.read(oggSyncState.data, idx, BUFSIZ);
    } catch (IOException e) {
        return e.getMessage();
    }
    if (count > 0)
        oggSyncState.wrote(count);
    return (count > 0) ? null : EOS;
}