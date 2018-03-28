protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    templateType = xr.getAttribute(TEMPLATE_TYPE_TAG, TemplateType.class, TemplateType.TEMPLATE);
    defaultId = xr.getAttribute(DEFAULT_ID_TAG, (String) null);
}