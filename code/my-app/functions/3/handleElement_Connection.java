public Element handleElement(Element request) throws FreeColException {
    return (this.domMessageHandler == null) ? null : this.domMessageHandler.handle(this, request);
}