public static String message(StringTemplate template) {
    if (template == null)
        return null;
    String result = "";
    switch(template.getTemplateType()) {
        case LABEL:
            List<StringTemplate> replacements = template.getReplacements();
            if (replacements.isEmpty()) {
                result = message(template.getId());
            } else {
                StringBuilder sb = new StringBuilder(64);
                for (StringTemplate other : replacements) {
                    sb.append(template.getId()).append(message(other));
                }
                if (sb.length() >= template.getId().length()) {
                    result = sb.toString().substring(template.getId().length());
                } else {
                    logger.warning("incorrect use of template " + template);
                }
            }
            break;
        case TEMPLATE:
            if (containsKey(template.getId())) {
                result = messageBundle.get(template.getId());
            } else if (template.getDefaultId() != null) {
                result = messageBundle.get(template.getDefaultId());
            }
            result = replaceChoices(result, template);
            for (String key : template.getKeys()) {
                result = result.replace(key, message(template.getReplacement(key)));
            }
            break;
        case KEY:
            String key = messageBundle.get(template.getId());
            result = (key == null) ? template.getId() : replaceChoices(key, null);
            break;
        case NAME:
        default:
            result = template.getId();
            break;
    }
    return result;
}