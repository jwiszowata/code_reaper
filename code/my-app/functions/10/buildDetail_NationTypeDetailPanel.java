public void buildDetail(String id, JPanel panel) {
    if (getId().equals(id))
        return;
    NationType nationType = getSpecification().getNationType(id);
    if (nationType instanceof EuropeanNationType) {
        buildEuropeanNationTypeDetail((EuropeanNationType) nationType, panel);
    } else if (nationType instanceof IndianNationType) {
        buildIndianNationTypeDetail((IndianNationType) nationType, panel);
    }
}