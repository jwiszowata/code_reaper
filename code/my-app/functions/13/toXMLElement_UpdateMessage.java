public Element toXMLElement() {
    DOMMessage message = new DOMMessage(TAG);
    final int n = this.fcgos.size();
    for (int i = 0; i < n; i++) {
        List<String> part = this.fields.get(i);
        if (part == null) {
            message.add(this.fcgos.get(i), this.destination);
        } else {
            message.add(this.fcgos.get(i), part);
        }
    }
    return message.toXMLElement();
}