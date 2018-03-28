public AttributeMessage toMessage(ServerPlayer serverPlayer) {
    if (!isNotifiable(serverPlayer))
        return null;
    AttributeMessage ret = new AttributeMessage(this.name);
    ret.setStringAttributes(this.attributes);
    return ret;
}