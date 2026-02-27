package org.healthCareSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInput {
    // Make it single object
    private static UserInput userInput = new UserInput();

    private UserInput(){};

    public static UserInput getUserInputInstance(){
        return userInput;
    }

    Scanner scan = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

    public int get_Id(){
        System.out.print("Enter ID : ");
        int id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public String get_Name(){
        System.out.print("Enter Name : ");
        return scan.nextLine();
    }

    public String get_BloodType(){
        String bloodType;

        while (true){
            System.out.print("Enter Blood Type : ");
            bloodType = scan.nextLine();

            try{
                if(!Pattern.matches("(A|B|AB|O)[+-]?", bloodType)){
                    throw new Exception("Invalid Blood Type. ");
                }
                return bloodType; // return only valid input is provided
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String get_medicalCondition(){
        System.out.print("Enter Medical Condition : ");
        return scan.nextLine();
    }

    public Date get_date(){
        String date;

            while(true){
                System.out.print("Enter Date (M/dd/yyy) : ");
                date = scan.nextLine();

                try{
                    // Check date format
                    if(!Pattern.matches("([1-9]|1[0-2])/([1-9]|[12][0-9]|3[01])/[0-9]{4}", date)){
                        throw new Exception("Invalid Date Format. ");
                    }
                    // Check validity of date
                    if(!validDate(date)){
                        throw  new Exception("Invalid Date. ");
                    }
                    return sdf.parse(date);
                }
                catch (ParseException e){
                    throw new RuntimeException(e);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
    }

    public boolean validDate(String date){
        sdf.setLenient(false); // strict parsing to invalid date (e.g 2/30/2024)
        try {
            sdf.parse(date); // If sdf can't parse, it will return false
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String get_Doctor(){
        System.out.print("Enter Doctor Name : ");
        return scan.nextLine();
    }

    public String get_Hospital(){
        System.out.print("Enter Hospital : ");
        return scan.nextLine();
    }

    public int get_roomNumber(){
        String roomNumber;

        while(true){
            try {
                System.out.print("Enter Room Number : ");
                roomNumber = scan.nextLine();

                if(!Pattern.matches("[0-9]{3}", roomNumber)){
                    throw new Exception("Room Number Must Include 3 digits.");
                }
                return Integer.parseInt(roomNumber);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String get_medication(){
        System.out.print("Enter Medication : ");
        return scan.nextLine();
    }

    public String get_testResult(){
        String testResult;

        while(true){
            System.out.print("Enter Test Result (Normal/Abnormal/Inconclusive) : ");
            testResult = scan.nextLine();

            try{
                if(!Pattern.matches("(Normal|Abnormal|Inconclusive)", testResult)){
                    throw new Exception("Invalid Test Result.");
                }
                return testResult;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

/*
    // test
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
//       System.out.println("Date : " + userInput.get_date());
        System.out.println("Room Number : " + userInput.get_roomNumber());
        System.out.println("Test Result : " + userInput.get_testResult());
    }

 */
}
