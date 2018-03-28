private void listen() throws IOException, SAXException, XMLStreamException {
    this.in.enable();
    this.in.mark(Connection.BUFFER_SIZE);
    String tag = null;
    int replyId = -1;
    FreeColXMLReader xr = null;
    try {
        xr = new FreeColXMLReader(this.in);
        xr.nextTag();
        tag = xr.getLocalName();
        replyId = xr.getAttribute(Connection.NETWORK_REPLY_ID_TAG, -1);
    } catch (XMLStreamException xse) {
        tag = TrivialMessage.DISCONNECT_TAG;
    }
    Thread t = null;
    DOMMessage msg = null;
    switch(tag) {
        case TrivialMessage.DISCONNECT_TAG:
            msg = TrivialMessage.DISCONNECT_MESSAGE;
            t = update(msg);
            askToStop();
            break;
        case Connection.REPLY_TAG:
            try {
                this.in.enable();
                this.in.reset();
                msg = reader(this.in);
                reply(msg, replyId);
            } catch (IOException | SAXException ex) {
                reply(null, replyId);
                throw ex;
            }
            break;
        case Connection.QUESTION_TAG:
            this.in.enable();
            this.in.reset();
            msg = reader(this.in);
            t = query(msg, replyId);
            break;
        default:
            try {
                Message m = this.connection.reader(xr);
                if (m != null)
                    msg = (DOMMessage) m;
            } catch (FreeColException | XMLStreamException ex) {
                logger.log(Level.FINEST, "ReceivingThread: " + ex.getMessage());
            }
            if (msg == null) {
                this.in.enable();
                this.in.reset();
                msg = reader(this.in);
            }
            t = update(msg);
            break;
    }
    if (t != null)
        t.start();
    if (xr != null)
        xr.close();
}