public void setDOMMessageHandler(DOMMessageHandler mh) {
    Connection c = getConnection();
    if (c != null)
        c.setDOMMessageHandler(mh);
}