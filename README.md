# assignment3-bridge-pattern

##

- Name: Assel Yermekkyzy
- Group: SE-2524
- Topic: Bridge Pattern - Notification
- Repository URL: https://github.com/yerassell/assignment3-bridge-pattern.git
- Base Commit: b0141ba3923d26aac2c2f25ac332d71c43cdb0a5
- Extended Commit: 

## Table Mapping

| Structure | Class names| Source Path |
|------|-------|-------------|
| Abstraction | Notification | src/abstraction/Notification.java |
| A1 | Reminder | src/abstraction/Reminder.java |
| A2 | UrgentAlert | src/abstraction/UrgentAlert.java |
| Implementor | Channel | src/implementor/Channel.java |
| I1 | EmailChannel | src/implementor/EmailChannel.java |
| I2 | SmsChannel | src/implementor/SmsChannel.java |
| I3 | PushChannel | src/implementor/PushChannel.java |
| Client | Main | src/Main.java |

## Inside code

- Bridge field: `protected Channel channel` — declared in `Notification.java`. 
- `execute()`: Declared in `Notification.java` and implemented in `Reminder.java` and `UrgentAlert.java`. The `channel.send()` is called inside.
- `setImplementation()`: Declared in `Notification.java`. It is used to switch between channels at a runtime.
- T5 check: It is located in `Main.java`. It creates A1 with I1 and then calls `setImplementation()` to switch from I1 to I2 and checks for the unchanged states of the object.

## How to Run

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected Results

| Check | Setup or action | Expected results |
|------|-------|-------------|
| T1 | A1 with I1  | EMAIL-> Reminder: Prepare for midterm |
| T2 | A1 with I2  | SMS-> Reminder: Prepare for midterm |
| T3 | A2 with I1  | EMAIL-> URGENT: Submit assignment3 |
| T4 | A2 with I2  | SMS-> URGENT: Submit assignment3 |
| T5 | On one A1 object, run with I1, replace it with I2, then run again. | T5 PASS \| sameObject=true \| stateUnchanged=true before=EMAIL-> Reminder: Tomorrow's quiz \| after=SMS-> Reminder: Tomorrow's quiz |
| T6 | A1 with the new I3   | PUSH-> Reminder: Prepare for midterm |
| T7 | A2 with the new I3   | PUSH-> URGENT: Submit assignment3 |
