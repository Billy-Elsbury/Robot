import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private boolean working = false;

    public Robot(String name) {
        setName(name);
    }

    private void setName (String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
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
