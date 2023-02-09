import org.junit.jupiter.api.*;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Robot4Test {
    Robot buddy ;

    @BeforeAll
    public void setup() {
        buddy = new Robot("buddy", 20);
        System.out.println("in setup");
    }

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        buddy.turnoffRobot();

        System.out.println("in before each");

    }

    @Test
    @Order(1)
    public void getNameTest() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    @Order(2)
    public void isNotWorkingTest(){
        assertFalse(buddy.isWorking());
    }

    @Test
    @Order(4)
    public void isWorkingTest(){
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    @Order(5)
    public void getWorkingMsg() {
        buddy.talkToRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }

    @Test()
    @Order(6)
    @DisplayName(" getWorkingFail catch the exception")
    public void getWorkingMsgFail() {

        assertThrows(IllegalStateException.class, () -> {
            buddy.getWorkingMsg();
        });
    }



    @Test()
    public void testName_Fail() {

        assertThrows(IllegalArgumentException.class, () -> {
            Robot4Test chuck = new Robot4Test();


        });
    }
    @Disabled("disabled until x class created")
    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            buddy.waitTillWorking();
        });
    }

    @AfterAll

    public static void cleanUp(){

        System.out.println("After All cleanUp() method called");

    }

    @AfterEach

    public void cleanUpEach(){

        System.out.println("After Each cleanUpEach() method called");

    }
}