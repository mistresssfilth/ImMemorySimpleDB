import controller.RecordController;
import entity.Record;

public class Main {
    public static void main(String[] args) {
        Record record1 = new Record(130L, "Alex", 25.0);
        Record record2 = new Record(2392L, "Anton", 102.13);
        Record record3 = new Record(332L, "Tom", 2001.0);
        Record record4 = new Record(2L, "Tom", 31891.131);

        RecordController recordController = new RecordController();
        recordController.addRecord(record1);
        recordController.addRecord(record2);
        recordController.addRecord(record3);
        recordController.addRecord(record4);

        recordController.printAllRecords();

        System.out.println("------------------");

        System.out.println(recordController.getByAccount(130L));

        System.out.println("------------------");

        System.out.println(recordController.getRecordByName("Tom"));

        System.out.println("------------------");

        System.out.println(recordController.getRecordByValue(102.13));

        System.out.println("------------------");

        recordController.updateRecord(130L, "Alexander", 140.140);
        System.out.println(recordController.getByAccount(130L));

        System.out.println("------------------");

        recordController.updateNameByAccount(130L, "Al");
        System.out.println(recordController.getByAccount(130L));

        System.out.println("------------------");

        recordController.updateValueByAccount(130L, 100101010.13);
        System.out.println(recordController.getByAccount(130L));

        System.out.println("------------------");
        System.out.println("Before");

        recordController.printAllRecords();
        recordController.deleteRecord(130L);
        System.out.println("After");
        recordController.printAllRecords();
    }
}
