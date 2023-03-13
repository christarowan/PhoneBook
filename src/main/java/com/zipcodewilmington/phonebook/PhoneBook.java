package com.zipcodewilmington.phonebook;


import java.util.*;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {


    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        this.phonebook = map;
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));

    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)) {
            return true;
        }
        return false;
    }

    public Boolean hasEntry(String name, String phoneNumber) {

        if (phonebook.containsKey(name)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        }
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            String key = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            for (String number : phoneNumbers) {
                if (number.equals(phoneNumber)) {
                    return key;
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> result = new ArrayList<String>();
        phonebook.forEach(
                (key, value)
                        -> result.add(key));
        return result;
    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
