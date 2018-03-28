public void hyperlinkUpdate(HyperlinkEvent e) {
    HyperlinkEvent.EventType type = e.getEventType();
    if (type == HyperlinkEvent.EventType.ACTIVATED) {
        String[] path = e.getURL().getPath().split("/");
        if (null != path[1]) {
            switch(path[1]) {
                case FreeColObject.ID_ATTRIBUTE_TAG:
                    select(path[2]);
                    break;
                case "action":
                    getFreeColClient().getActionManager().getFreeColAction(path[2]).actionPerformed(null);
                    break;
                default:
                    break;
            }
        }
    }
}