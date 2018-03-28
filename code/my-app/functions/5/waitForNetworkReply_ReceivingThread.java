public NetworkReplyObject waitForNetworkReply(int networkReplyId) {
    NetworkReplyObject nro = new NetworkReplyObject(networkReplyId);
    waitingThreads.put(networkReplyId, nro);
    return nro;
}