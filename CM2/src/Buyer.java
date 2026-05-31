public class Buyer {

    private int queueNumber;
    private String name;
    private String mobileNumber;

    public Buyer(String name, String mobileNumber) {
        setName(name);
        setMobileNumber(mobileNumber);
        this.queueNumber = 0;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setQueueNumber(int queueNumber) {
        if (queueNumber > 0) {
            this.queueNumber = queueNumber;
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setMobileNumber(String mobileNumber) {
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            this.mobileNumber = mobileNumber;
        }
    }

    @Override
    public String toString() {
        return "Buyer{queueNumber=" + queueNumber +
               ", name='" + name + "'" +
               ", mobileNumber='" + mobileNumber + "'}";
    }
}