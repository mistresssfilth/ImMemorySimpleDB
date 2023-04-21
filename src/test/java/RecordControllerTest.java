import entity.Record;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.RecordController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecordControllerTest {
    private RecordController recordController;
    private static Record record;

    @BeforeAll
    static void create(){
        record = new Record(666L, "Record", 250.14);
    }
    @BeforeEach
    void init(){
        recordController = new RecordController();
        recordController.addRecord(record);
    }

    @Test
    void addRecordTest(){
        Record newRecord = new Record(10L, "New Record", 13910.13);
        recordController.addRecord(newRecord);
        assertEquals(newRecord, recordController.getByAccount(newRecord.getAccount()));
    }

    @Test
    void getRecordByAccountTest(){
        Record found = recordController.getByAccount(record.getAccount());
        assertEquals(found, record);
    }
    @Test
    void getRecordByNameTest(){
        Record newRecord = new Record(10L, "Record", 13910.13);
        Record newRecord1 = new Record(115L, "Another", 13910.13);
        recordController.addRecord(newRecord);
        recordController.addRecord(newRecord1);
        List<Record> res = new ArrayList<>();
        res.add(record);
        res.add(newRecord);

        List<Record> found = recordController.getRecordByName(record.getName());
        assertEquals(res, found);

    }
    @Test
    void getRecordByValueTest(){
        Record newRecord = new Record(10L, "New Record", 10.13);
        Record newRecord1 = new Record(115L, "Another new Record", 250.14);
        recordController.addRecord(newRecord);
        recordController.addRecord(newRecord1);
        List<Record> res = new ArrayList<>();
        res.add(record);
        res.add(newRecord1);

        List<Record> found = recordController.getRecordByValue(record.getValue());
        assertEquals(res, found);
    }
    @Test
    void deleteRecordTest(){
        Record newRecord = new Record(10L, "New Record", 10.13);
        recordController.addRecord(newRecord);
        recordController.deleteRecord(newRecord.getAccount());

        assertNull(recordController.getByAccount(newRecord.getAccount()));
        assertFalse(recordController.getRecordByName(newRecord.getName()).contains(newRecord));
        assertFalse(recordController.getRecordByValue(newRecord.getValue()).contains(newRecord));
    }

    @Test
    void updateValueTest(){
        Record newRecord = new Record(666L, "Record", 10.13);
        recordController.updateValueByAccount(record.getAccount(), 10.13);
        assertEquals(newRecord, recordController.getByAccount(record.getAccount()));
    }
    @Test
    void updateNameTest(){
        Record newRecord = new Record(666L, "Edited Record", 250.14);
        recordController.updateNameByAccount(record.getAccount(), "Edited Record");
        assertEquals(newRecord, recordController.getByAccount(record.getAccount()));
    }
    @Test
    void updateRecordTest(){
        Record newRecord = new Record(666L, "Edited Record", 10.13);
        recordController.updateRecord(record.getAccount(), "Edited Record", 10.13);
        assertEquals(newRecord, recordController.getByAccount(record.getAccount()));

    }


}
