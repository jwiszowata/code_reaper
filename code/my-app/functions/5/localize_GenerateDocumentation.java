public static String localize(String template, String key, String number) {
    double num = Double.parseDouble(number);
    StringTemplate stringTemplate = StringTemplate.template(template).addAmount(key, num);
    return Messages.message(stringTemplate);
}