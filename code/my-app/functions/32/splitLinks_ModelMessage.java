public List<Object> splitLinks(Player player) {
    final FreeColGameObject source = player.getGame().getMessageSource(this);
    List<Object> result = new ArrayList<>();
    result.add(Messages.message(this));
    for (String key : getKeys()) {
        String val = Messages.message(getReplacement(key));
        if (val == null)
            continue;
        Object b = Utility.getMessageButton(key, val, player, source);
        if (b == null)
            continue;
        List<Object> next = new ArrayList<>();
        for (Object o : result) {
            if (o instanceof String) {
                String str = (String) o;
                int index, start = 0;
                while ((index = str.indexOf(val, start)) >= 0) {
                    if (index > start) {
                        next.add(str.substring(start, index));
                    }
                    next.add(b);
                    start = index + val.length();
                }
                next.add(str.substring(start, str.length()));
            } else {
                next.add(o);
            }
        }
        result = next;
    }
    return result;
}