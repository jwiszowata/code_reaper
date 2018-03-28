public Message build(ServerPlayer serverPlayer) {
    if (this.changes.isEmpty())
        return null;
    List<Message> messages = new ArrayList<>();
    List<Message> diverted = new ArrayList<>();
    for (Change c : this.changes) {
        if (!c.isNotifiable(serverPlayer))
            continue;
        Message m = c.toMessage(serverPlayer);
        List<Message> onto = (m.canMergeAttributes()) ? diverted : messages;
        onto.add(m);
        if ((c = c.consequence(serverPlayer)) != null) {
            m = c.toMessage(serverPlayer);
            onto = (m.canMergeAttributes()) ? diverted : messages;
            onto.add(m);
        }
    }
    messages.sort(Message.messagePriorityComparator);
    diverted.sort(Message.messagePriorityComparator);
    if (messages.size() > 1) {
        List<Message> more = new ArrayList<>();
        Message head = messages.remove(0);
        while (!messages.isEmpty()) {
            Message m = messages.remove(0);
            if (!head.merge(m)) {
                more.add(head);
                head = m;
            }
        }
        more.add(head);
        messages = more;
    }
    Message ret;
    switch(messages.size()) {
        case 0:
            ret = null;
            break;
        case 1:
            ret = messages.get(0);
            break;
        default:
            MultipleMessage mm = new MultipleMessage();
            for (Message m : messages) mm.addMessage((DOMMessage) m);
            ret = mm;
            break;
    }
    if (!diverted.isEmpty()) {
        if (ret == null)
            ret = new UpdateMessage(null, (FreeColObject) null);
        for (Message m : diverted) ret.merge(m);
    }
    return ret;
}