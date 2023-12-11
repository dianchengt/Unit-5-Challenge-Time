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
   * 
   * POSTCONDITION: second will be less than 60
   * POSTCONDITON: minute will be less than 60
   * POSTCONDITION: hour will be less than 24
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
   * 
   * The method checks the length of each variable. 
   * If the length is 1, a "0" will be concatenated to the front. 
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
   * 
   * PRECONDITION: the time must be in HH:MM:SS form
   *
   * The method obtains the hour, minute, and second of the parameter as integers. 
   * It adds each of the values to the current time. 
   * If any of the new values goes over the limit the next variable increases by 1.
   * The value is then subtracted by the limit. 
   *
   * @param time The time to add to the current time
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
