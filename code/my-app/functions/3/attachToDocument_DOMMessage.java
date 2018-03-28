public Element attachToDocument(Document doc) {
    return (Element) doc.adoptNode(this.toXMLElement());
}