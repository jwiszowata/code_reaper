public Location getCarrierTarget() {
    return (getMode().isCollection()) ? plan.cwait : plan.cdst;
}