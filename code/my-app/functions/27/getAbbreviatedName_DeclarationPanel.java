private String getAbbreviatedName(String name) {
    if (!isTooLarge(name))
        return name;
    String[] partNames = name.split(" ");
    for (int i = 1; i < partNames.length - 1 && isTooLarge(join(" ", partNames)); i++) {
        partNames[i] = partNames[i].charAt(0) + ".";
    }
    while (partNames.length > 2 && isTooLarge(join(" ", partNames))) {
        String[] newPartNames = new String[partNames.length - 1];
        newPartNames[0] = partNames[0];
        for (int i = 1; i < newPartNames.length; i++) {
            newPartNames[i] = partNames[i + 1];
        }
        partNames = newPartNames;
    }
    String first = partNames[0], second = partNames[1];
    String s = join(" ", partNames);
    if (!isTooLarge(s))
        return s;
    s = first.charAt(0) + ". " + second;
    if (!isTooLarge(s))
        return s;
    s = first + " " + second.charAt(0) + ".";
    if (!isTooLarge(s))
        return s;
    return first.charAt(0) + ". " + second.charAt(0) + ".";
}