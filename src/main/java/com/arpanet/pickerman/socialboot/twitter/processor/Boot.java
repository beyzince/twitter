package com.arpanet.pickerman.socialboot.twitter.processor;

import java.util.GregorianCalendar;

public abstract class Boot {


    abstract void like() throws InterruptedException;

    abstract void tweet() throws InterruptedException;

    abstract void retweet() throws InterruptedException;

    abstract void reply() throws InterruptedException;

    abstract void delete() throws InterruptedException;

    abstract void account() throws InterruptedException;

    abstract void logout();

    abstract public void start() throws InterruptedException;

    abstract void login() throws InterruptedException;


    protected int countLike() {

        return (int) Math.random();
    }
    /*

    protected void selectDate(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1950, 2021);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

     */




    /*
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
    String stringDate= DateFor.format(date);
    System.out.println(stringDate);
    -------------
        Date date = // the date instanceCalendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        localDate.getYear();
        localDate.getMonthValue();
        localDate.getDayOfMonth();
        --------
        int currentYear=Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth=Calendar.getInstance().get(Calendar.MONTH);
        int currentDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Calendar from = new GregorianCalendar(currentYear - maxAge, currentMonth, currentDay);
        Calendar to = new GregorianCalendar(currentYear - minAge, currentMonth, currentDay);

        return between(from.getTime(), to.getTime());


    }
    */
    /*

    protected int RandomDates{
        for (int i = 0; i < 10; i++) {
            LocalDate randomDate = createRandomDate(1900, 2000);
            System.out.println(randomDate);

        }
    }
    protected  int createRandomIntBetween(int start, int end){
        return start + (int) Math.round(Math.random() * (end - start));
    }
    protected  int LocalDate createRandomDate(int startYear, int endYear){
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);

    }

     */



}
