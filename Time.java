/** 
 * This class represents a time object
 *
 * @author Diancheng Tang
 */

public class Time{

  /** The hour of the time */
  private int hour;

  /** The minute of the time */
  private int minute;

  /** The second of the time */
  private int second;

  /**
   * Instantiates a Time object.
   *
   * @param hour The hour
   * @param minute The minute
   * @param second The second
   */
  public Time(int hour, int minute, int second){
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /**
   * Non-static void method that adds one second to the time
   * <p>
   * POSTCONDITION: When second is 59 before adding, minute increases by 1 instead and second is resetted to 0. When minute and second are both 59 before adding, both values are resetted to 0 and hour increases by 1 instead. If the time is 23:59:59 before adding, all the values are resetted to 0. 
   */
  public void tick(){
    second ++;
    if(second == 60){
      minute ++;
      second  = 0;
    }
    if(minute == 60){
      hour ++;
      minute = 0;
    }
    if(hour == 24){
      hour = 0;
    }
  }

  /**
   * Non-static String method that returns the time in HH:MM:SS form in military time
   * <p>
   * The method checks the length of each variable. If the length is 1, a "0" will be concatenated to the front. 
   *
   * @return the time in HH:MM:SS form in military time
   */
  public String info(){
    String returnStr = "";
    String hourStr = "" + hour;
    String minuteStr = "" + minute;
    String secondStr = "" + second;
    if(hourStr.length() == 1){
      returnStr += "0" + hour + ":";
    }else{
      returnStr += hour + ":";
    }
    if(minuteStr.length() == 1){
      returnStr += "0" + minute + ":";
    }else{
      returnStr += minute + ":";
    }
    if(secondStr.length() == 1){
      returnStr += "0" + second;
    }else{
      returnStr += second;
    }
    return returnStr;
  }

  /**
   * Non-static void method that adds the time in the parameter to the current time
   * <p>
   * PRECONDITION: the time must be in HH:MM:SS form
   *
   * The method uses the Integer.parseInt() method to obtain the hour, minute, and second of the parameter as integers. Then, it adds each of the values to the current time. If any of the new values goes over the limit (i.e if second is >= 60, if minute >= 60, and if hour >= 24), the next variable increases by 1 and the value is subtracted by the limit. 
   *
   * @param time The time
   */
  public void add(String time){
    int hr = Integer.parseInt(time.substring(0, 2));
    int min = Integer.parseInt(time.substring(3, 5));
    int sec = Integer.parseInt(time.substring(6));
    second += sec;
    if(second >= 60){
      minute ++;
      second -= 60;
    }
    minute += min;
    if(minute >= 60){
      hour ++;
      minute -= 60;
    }
    hour += hr;
    if(hour >= 24){
      hour -= 24;
    }
  }
}
