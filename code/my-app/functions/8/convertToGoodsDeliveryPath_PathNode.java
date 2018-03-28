public void convertToGoodsDeliveryPath() {
    PathNode p;
    for (p = this; p.next != null; p = p.next) {
        p.onCarrier = true;
    }
    p.onCarrier = true;
    ensureDisembark();
}