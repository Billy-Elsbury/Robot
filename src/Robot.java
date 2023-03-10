import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private boolean working = false;
    private int age;

    public Robot(String name, int age) {
        setName(name);
        setAge(age);
    }

    public double checkCost() {
        if (age <= 5) {
            return 10000.00;
        } else if (age <= 10) {
            return 7500.00;
        } else return 5000.00;
    }

    private void setName (String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }


    private void setAge(int age) {
        if (age <= 30) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();

        }

    }

    public String checkage() {
        if (age <= 20) {
            return "Age ok";
        } else {
            return "Too old";
        }
    }


    public String getName() {
        return name;
    }

    public boolean isWorking(){
        return working;

    }

    public void talkToRobot() {
        working = true;

    }

    public String getWorkingMsg() {
        if(!working) {
            throw new IllegalStateException();

        }
        return "I am in working mode";
    }

    public void waitTillWorking() throws InterruptedException {
        //while (!working)
        {
            // do nothing

            sleep(100);
        }
    }

    public void turnoffRobot() {
        working=false;
    }
}
