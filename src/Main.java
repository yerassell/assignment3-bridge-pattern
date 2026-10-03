import abstraction.Notification;
import abstraction.Reminder;
import abstraction.UrgentAlert;
import implementor.Channel;
import implementor.EmailChannel;
import implementor.SmsChannel;

public class Main{
    public static void main(String[] args){

        int passed = 0;
        Reminder r1 = new Reminder("1", new EmailChannel(), "Prepare for midterm");
        passed += check("T1", "Reminder + EmailChannel", r1.execute(), "EMAIL-> Reminder: Prepare for midterm");
        Reminder r2 = new Reminder("2", new SmsChannel(), "Prepare for midterm");
        passed += check("T2", "Reminder + SmsChannel", r2.execute(), "SMS-> Reminder: Prepare for midterm");

        UrgentAlert u1 = new UrgentAlert("3", new EmailChannel(), "Submit assignment3");
        passed += check("T3", "UrgentAlert + EmailChannel", u1.execute(), "EMAIL-> URGENT: Submit assignment3");
        UrgentAlert u2 = new UrgentAlert("4", new SmsChannel(), "Submit assignment3");
        passed += check("T4", "UrgentAlert + SmsChannel", u2.execute(), "SMS-> URGENT: Submit assignment3");

        Reminder s = new Reminder("5", new EmailChannel(), "Tomorrow's quiz");
        String before = s.execute();
        String id = s.getId();
        String message = s.getMessage();
        Notification reference = s;
        s.setImplementation(new SmsChannel());
        String after = s.execute();
        boolean sameObject = (reference == s);
        boolean stateUnchanged = id.equals(s.getId()) && message.equals(s.getMessage());
        if (sameObject && stateUnchanged && before.equals("EMAIL-> Reminder: Tomorrow's quiz") && after.equals("SMS-> Reminder: Tomorrow's quiz")){
            System.out.println("T5 PASS | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged + " before=" + before + " | after=" + after);
            passed++;
        }
        else{
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged + " | before=" + before + " | after=" + after);
            System.out.println("Expected before: EMAIL-> Reminder: Tomorrow's quiz");
            System.out.println("Expected after: SMS-> Reminder: Tomorrow's quiz");
        }

        System.out.println("SUMMARY: " + passed + "/5 PASS");
    }
    private static int check(String id, String setup, String actual, String expected){
        if (actual.equals(expected)){
            System.out.println(id + " PASS | " + setup + " | result=" + actual);
            return 1;
        }
        else{
            System.out.println(id + " FAIL | " + setup + " | result=" + actual);
            System.out.println("Expected: " + expected);
            return 0;
        }
    }
}
