package singletonClasses;

public class Singleton {
    private String objectState;
    private static Singleton instance = null;

    private Singleton() throws Exception {
        this.objectState = "Javatpoint";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            try {
                instance = new Singleton();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public String getObjectState() {
        return objectState;
    }

    public void setObjectState(String objectState) {
        this.objectState = objectState;
    }
}
