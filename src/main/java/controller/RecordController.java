package controller;

import entity.Record;
import exceprions.NullRecordException;
import exceprions.RecordExistException;


import java.util.*;


public class RecordController {
    private TreeMap<Long, Record> accounts;
    private TreeMap<String, ArrayList<Record>> names;
    private TreeMap<Double, ArrayList<Record>> values;

    public RecordController() {
        accounts = new TreeMap<>();
        names = new TreeMap<>();
        values = new TreeMap<>();
    }

    public void addRecord(Record record) throws NullRecordException {
        if (record == null)
            throw new NullRecordException("Record is null");

        if (!accounts.containsKey(record.getAccount()))
            accounts.put(record.getAccount(), record);
        else throw new RecordExistException("Record is already exist");

        if (!names.containsKey(record.getName()))
            names.put(record.getName(), new ArrayList<>());
        names.get(record.getName()).add(record);

        if (!values.containsKey(record.getValue()))
            values.put(record.getValue(), new ArrayList<>());
        values.get(record.getValue()).add(record);
    }

    public Record getByAccount(Long account) {
        try {
            return accounts.get(account);
        } catch (NullRecordException e) {
            throw new NullRecordException("Record is not exist");
        }
    }

    public List<Record> getRecordByName(String name) {
        try {
            return names.get(name);
        } catch (NullRecordException e) {
            throw new NullRecordException("Records is not exist");
        }
    }

    public List<Record> getRecordByValue(Double value) {
        try {
            return values.get(value);
        } catch (NullRecordException e) {
            throw new NullRecordException("Records is not exist");
        }
    }

    public void deleteRecord(Long account) {

        try {
            String name = getByAccount(account).getName();
            Double value = getByAccount(account).getValue();
            Record record = new Record(account, name, value);

            accounts.remove(account);
            getRecordByName(name).remove(record);
            getRecordByValue(value).remove(record);

            System.out.println("Record deleted access");

        } catch (NullRecordException e) {
            throw new NullRecordException("Record is not exist");

        }

    }

    public void updateNameByAccount(Long account, String newName) {

        try {
            Record record = getByAccount(account);
            deleteRecord(account);
            record.setName(newName);
            addRecord(record);
        } catch (NullRecordException e) {
            throw new NullRecordException("Record is not exist");
        }


    }

    public void updateValueByAccount(Long account, Double newValue) {

        try {
            Record record = getByAccount(account);
            deleteRecord(account);
            record.setValue(newValue);
            addRecord(record);
        } catch (NullRecordException e) {
            throw new NullRecordException("Record is not exist");
        }

    }

    public void updateRecord(Long account, String newName, Double newValue) {

        try {
            Record record = getByAccount(account);
            deleteRecord(account);
            record.setName(newName);
            record.setValue(newValue);
            addRecord(record);
        } catch (NullRecordException e) {
            throw new NullRecordException("Record is not exist");
        }

    }

    public void printAllRecords(){
        for (Map.Entry<Long, Record> r : accounts.entrySet()){
            System.out.println(r);
        }
    }
}
