package Utility;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class Utility{


     public static double Calc(double num1, char opr, double num2) {

         Map<Character, Double> _Calc = new HashMap<>();

         _Calc.put('+', num1 + num2);
         _Calc.put('-', num1 - num2);
         _Calc.put('*', num1 * num2);
         _Calc.put('/', num1 / num2);
         _Calc.put('%', num1 % num2);

        return _Calc.get(opr);
     }
     public static float Calc(float num1, char opr, float num2) {

         Map<Character, Float> _Calc = new HashMap<>();

         _Calc.put('+', num1 + num2);
         _Calc.put('-', num1 - num2);
         _Calc.put('*', num1 * num2);
         _Calc.put('/', num1 / num2);
         _Calc.put('%', num1 % num2);

        return _Calc.get(opr);
     }

     public static String OfDivided(long number) {

        if (number == 0) return String.format("%d", 0);

        List<Integer> Answer = new ArrayList<>();

        for (int i = 1; i <= 9; i++) if (number % i == 0) Answer.add(i);

        return String.format("%s", Answer);
    }

     public static double AVG(String NumList){

        String[] Parts = NumList.split(",");

        double AVG = 0;

        for (String part : Parts) {
            AVG += Float.parseFloat(part.trim());
        }

        AVG /= Parts.length;

        return AVG;
    }

     public static boolean CompareNum(int num1, char opr, int num2){
         if(opr == '<') return num1 < num2;

         else if(opr == '>') return num1 > num2;

         return true;
     }

     public static boolean CompareNum(float num1, char opr, float num2){
         if(opr == '<') return num1 < num2;

         else if(opr == '>') return num1 > num2;

         return true;
     }

     public static boolean CompareNum(double num1, char opr, double num2){

         return switch(opr){
             case '<' -> num1 < num2;
             case '>' -> num1 > num2;
             default -> throw new IllegalStateException("Unexpected value: " + opr);
         };


     }

     public static boolean CompareNum(long num1, char opr, long num2){
         if(opr == '<') return num1 < num2;

         else if(opr == '>') return num1 > num2;

         return true;
     }

     public static float BMICalc(float weight, float height){

        return Calc(weight, '/', (float) Math.pow( (height / 100 ), 2));
    }

     public static void Timer_(int hour, int min, int sec){

        String TimeF;

        do {

            TimeF = String.format("%02d : %02d : %02d", hour, min, sec);

            System.out.print("\r" + TimeF);

            if(TimeF.equals("00 : 00 : 00")) break;

            delay(1000);

            sec--;

            if (sec == -1) {
                min--;
                sec = 59;

            }
            if (min == -1) {
                hour--;
                min = 59;
            }

        } while (hour > -1);
    }

     public static void GUI_Timer(String title, int width, int height, int fontSize, int hour, int min, int sec) {
        JFrame f = new JFrame(title);
        JLabel l = new JLabel("", JLabel.CENTER);
        f.setVisible(true);
        f.setSize(width, height);
        l.setFont(new Font("Arial", Font.PLAIN, fontSize));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);

        boolean visibility = true;

        String TimeF;

        do {

            TimeF = String.format("%02d : %02d : %02d", hour, min, sec);

            l.setText(TimeF);

            if(TimeF.equals("00 : 00 : 00")){
                while(true){
                    visibility = !visibility;
                    l.setText("Timer Ended");
                    delay(500);
                    l.setVisible(visibility);
                }
            }

            delay(1000);

            sec--;

            if (sec == -1) {
                min--;
                sec = 59;

            }
            if (min == -1) {
                hour--;
                min = 59;
            }

        } while (hour > -1);


    }

     public static void GUI_Timer(String title, int width, int height, int fontSize, String timeFormat) {

        JFrame f = new JFrame(title);
        JLabel l = new JLabel("", JLabel.CENTER);
        f.setVisible(true);
        f.setSize(width, height);
        l.setFont(new Font("Arial", Font.PLAIN, fontSize));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);

        String[] parts = timeFormat.split(":");
        int hour = Integer.parseInt(parts[0].trim());
        int min = Integer.parseInt(parts[1].trim());
        int sec = Integer.parseInt(parts[2].trim());
        boolean visibility = true;
        String TimeF;

        do {

            TimeF = String.format("%02d : %02d : %02d", hour, min, sec);

            l.setText(TimeF);

            if(TimeF.equals("00 : 00 : 00")){
                while(true){
                    visibility = !visibility;
                    l.setText("Timer Ended");
                    delay(500);
                    l.setVisible(visibility);
                }
            }

            delay(1000);

            sec--;

            if (sec == -1) {
                min--;
                sec = 59;

            }
            if (min == -1) {
                hour--;
                min = 59;
            }

        } while (hour > -1);


    }

     public static void Timer_(String timeFormat){

            String[] parts = timeFormat.split(":");
            int hour = Integer.parseInt(parts[0].trim());
            int min = Integer.parseInt(parts[1].trim());
            int sec = Integer.parseInt(parts[2].trim());

            String TimeF;

        do {

            TimeF = String.format("%02d : %02d : %02d", hour, min, sec);

            System.out.print("\r" + TimeF);

            if(TimeF.equals("00 : 00 : 00")) break;

            delay(1000);

            sec--;

            if (sec == -1) {
                min--;
                sec = 59;

            }
            if (min == -1) {
                hour--;
                min = 59;
            }

        } while (hour > -1);
    }

     public static void StopProgram(){System.exit(0);}

     public static void delay(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            HandleException(e);
        }
    }

     public static void StopWatch(){

            int min = 0;
            int sec = 0;
            int mil_sec = 0;

        while (true) {

                System.out.print("\r" + String.format("%02d : %02d : %02d", min, sec, mil_sec));

                mil_sec++;

                if(mil_sec > 10){
                    sec++;
                    mil_sec = 0;
                }

                if(sec > 60){
                    min++;
                    sec = 0;
                }
                delay(100);
          }
     }

     public static boolean isEven(long num){return num % 2 == 0;}

     public static int RandomNum(int min, int max){
         Random random = new Random();
         return random.nextInt((max - min)) + min;
     }

     public static String CurrentDate() {return LocalDate.now().toString();}

     public static String CurrentTime(String format) {

        if(format.equals("12")) return new SimpleDateFormat("hh : mm : ss a").format(new Date());

        else if(format.equals("24")){

            String[] parts =  LocalTime.now().toString().split("\\.");

            return parts[0].trim();
        }

        return " ";
     }

     public static void LiveCurrentTime(String format){

        if(format.equals("12")){

        SimpleDateFormat formatter = new SimpleDateFormat("hh : mm : ss a ");

         while(true)
        {
            System.out.print("\r" + formatter.format(new Date()));
            delay(1000);
        }

        }else if(format.equals("24")) {

            String[] parts;

         while(true)
        {
            parts = LocalTime.now().toString().split("\\.");
            System.out.print("\r" + parts[0].trim());
            delay(1000);
        }

        }

     }

     public static double RootOfNum(double num, char opr){

        if(opr == '√') return Math.sqrt(num);
        else if(opr == '∛') return Math.cbrt(num);

        return 0;

     }

     public static double RootOfNum(double num, String opr){

        if(opr.equalsIgnoreCase("sqrt")) return Math.sqrt(num);
        else if(opr.equalsIgnoreCase("cbrt")) return Math.cbrt(num);

        return 0;

     }

     public static class GameTimer implements Runnable {

         private static boolean Running = true;

         private static String Time = " ";

         public void run(){

         int hours = 0, minutes = 0, seconds = 0;

         while(Running)

         {
             Time = String.format("%02d : %02d : %02d", hours, minutes, seconds);
             System.out.print("\r" + Time);

             if(!Running) break;

             delay(1000);
             seconds++;

             if(seconds == 60) {
                 seconds = 0;
                 minutes++;
             }
             if(minutes == 60) {
                 minutes = 0;
                 hours++;
             }
         }
         }



         public static void start(){

             new Thread(new GameTimer()).start();
         }

         public static void Stop(){Running = false;}

         public static void StopAt(String time){

             Thread stop = new Thread(() -> {

                 while(Running){

                 if(Time.trim().equals(time.trim())) Running = false;

                 else delay(1);
         }
         });

             stop.start();
         }

     }

     public static void runCommand(String command){

        try {
            ProcessBuilder p = new ProcessBuilder("cmd.exe", "/c", "start", "\"\"",command);
            p.start();

        }catch(Exception e){

            HandleException(e);
        }
     }

     public static void HandleException(Exception e){

         System.out.println(e.getMessage() + e.getCause());
     }

     public static String CurrentDateTime() {return LocalDateTime.now().toString();}

     public static String Converter(double User_Value, String From_Unit, String To_Unit){

        Map<String, Function<Double, Double>> Converter_Storage = new HashMap<>();

        Converter_Storage.put("meter_centimeter", value -> value * 100.0);
        Converter_Storage.put("centimeter_meter", value -> value / 100.0);
        Converter_Storage.put("meter_kilometer", value -> value / 1000.0);
        Converter_Storage.put("kilometer_meter", value -> value * 1000.0);
        Converter_Storage.put("mile_kilometer", value -> value * 1.60934);
        Converter_Storage.put("kilometer_mile", value -> value / 1.60934);
        Converter_Storage.put("foot_meter", value -> value * 0.3048);
        Converter_Storage.put("meter_foot", value -> value / 0.3048);
        Converter_Storage.put("yard_meter", value -> value * 0.9144);
        Converter_Storage.put("meter_yard", value -> value / 0.9144);
        Converter_Storage.put("inch_meter", value -> value * 0.0254);
        Converter_Storage.put("meter_inch", value -> value / 0.0254);

        Converter_Storage.put("kilogram_gram", value -> value * 1000.0);
        Converter_Storage.put("gram_kilogram", value -> value / 1000.0);
        Converter_Storage.put("kilogram_pound", value -> value * 2.20462);
        Converter_Storage.put("pound_kilogram", value -> value / 2.20462);
        Converter_Storage.put("ounce_gram", value -> value * 28.3495);
        Converter_Storage.put("gram_ounce", value -> value / 28.3495);
        Converter_Storage.put("stone_kilogram", value -> value * 6.35029);
        Converter_Storage.put("kilogram_stone", value -> value / 6.35029);

        Converter_Storage.put("second_minute", value -> value / 60.0);
        Converter_Storage.put("minute_second", value -> value * 60.0);
        Converter_Storage.put("minute_hour", value -> value / 60.0);
        Converter_Storage.put("hour_minute", value -> value * 60.0);
        Converter_Storage.put("hour_day", value -> value / 24.0);
        Converter_Storage.put("day_hour", value -> value * 24.0);
        Converter_Storage.put("day_week", value -> value / 7.0);
        Converter_Storage.put("week_day", value -> value * 7.0);

        Converter_Storage.put("celsius_fahrenheit", value -> (value * 9.0 / 5.0) + 32.0);
        Converter_Storage.put("fahrenheit_celsius", value -> (value - 32.0) * 5.0 / 9.0);
        Converter_Storage.put("celsius_kelvin", value -> value + 273.15);
        Converter_Storage.put("kelvin_celsius", value -> value - 273.15);
        Converter_Storage.put("fahrenheit_kelvin", value -> (value - 32) * 5.0 / 9.0 + 273.15);
        Converter_Storage.put("kelvin_fahrenheit", value -> (value - 273.15) * 9.0 / 5.0 + 32.0);

        Converter_Storage.put("liter_milliliter", value -> value * 1000.0);
        Converter_Storage.put("milliliter_liter", value -> value / 1000.0);
        Converter_Storage.put("liter_gallon", value -> value * 0.264172);
        Converter_Storage.put("gallon_liter", value -> value / 0.264172);
        Converter_Storage.put("liter_cubicMeter", value -> value / 1000.0);
        Converter_Storage.put("cubicMeter_liter", value -> value * 1000.0);

        Converter_Storage.put("joule_calorie", value -> value * 0.239006);
        Converter_Storage.put("calorie_joule", value -> value / 0.239006);
        Converter_Storage.put("joule_kilowattHour", value -> value / 3600000.0);
        Converter_Storage.put("kilowattHour_joule", value -> value * 3600000.0);

        Converter_Storage.put("meter/Second_kilometer/Hour", value -> value * 3.6);
        Converter_Storage.put("kilometer/Hour_meter/Second", value -> value / 3.6);
        Converter_Storage.put("miles/Hour_meter/Second", value -> value * 0.44704);
        Converter_Storage.put("meter/Second_miles/Hour", value -> value / 0.44704);

        Converter_Storage.put("pascal_bar", value -> value * 0.00001);
        Converter_Storage.put("bar_pascal", value -> value * 100000.0);
        Converter_Storage.put("pascal_psi", value -> value * 0.000145038);
        Converter_Storage.put("psi_pascal", value -> value / 0.000145038);

        Converter_Storage.put("byte_kilobyte", value -> value / 1024.0);
        Converter_Storage.put("kilobyte_byte", value -> value * 1024.0);
        Converter_Storage.put("kilobyte_megabyte", value -> value / 1024.0);
        Converter_Storage.put("megabyte_kilobyte", value -> value * 1024.0);
        Converter_Storage.put("megabyte_gigabyte", value -> value / 1024.0);
        Converter_Storage.put("gigabyte_megabyte", value -> value * 1024.0);
        Converter_Storage.put("gigabyte_terabyte", value -> value / 1024.0);
        Converter_Storage.put("terabyte_gigabyte", value -> value * 1024.0);
        Converter_Storage.put("degree_radian", Math::toRadians);
        Converter_Storage.put("radian_degree", Math::toDegrees);
        Converter_Storage.put("degree_gradian", value -> value * 1.11111);
        Converter_Storage.put("gradian_degree", value -> value / 1.11111);
        Converter_Storage.put("squareMeter_squareKilometer", value -> value / 1000000.0);
        Converter_Storage.put("squareKilometer_squareMeter", value -> value * 1000000.0);
        Converter_Storage.put("squareMeter_acre", value -> value * 0.000247105);
        Converter_Storage.put("acre_squareMeter", value -> value / 0.000247105);
        Converter_Storage.put("squareMeter_hectare", value -> value * 0.0001);
        Converter_Storage.put("hectare_squareMeter", value -> value / 0.0001);
        Converter_Storage.put("squareFoot_squareMeter", value -> value * 0.092903);
        Converter_Storage.put("squareMeter_squareFoot", value -> value / 0.092903);
        Converter_Storage.put("cubicMeter_cubicFoot", value -> value * 35.3147);
        Converter_Storage.put("cubicFoot_cubicMeter", value -> value / 35.3147);
        Converter_Storage.put("cubicMeter_cubicInch", value -> value * 61023.7);
        Converter_Storage.put("cubicInch_cubicMeter", value -> value / 61023.7);
        Converter_Storage.put("liter_cubicInch", value -> value * 61.0237);
        Converter_Storage.put("cubicInch_liter", value -> value / 61.0237);
        Converter_Storage.put("joule_electronVolt", value -> value * 6.242e+18);
        Converter_Storage.put("electronVolt_joule", value -> value / 6.242e+18);
        Converter_Storage.put("joule_BTU", value -> value * 0.000947817);
        Converter_Storage.put("BTU_joule", value -> value / 0.000947817);
        Converter_Storage.put("kilowattHour_BTU", value -> value * 3412.14);
        Converter_Storage.put("BTU_kilowattHour", value -> value / 3412.14);
        Converter_Storage.put("pascal_atmosphere", value -> value / 101325.0);
        Converter_Storage.put("atmosphere_pascal", value -> value * 101325.0);
        Converter_Storage.put("pascal_torr", value -> value / 133.322);
        Converter_Storage.put("torr_pascal", value -> value * 133.322);
        Converter_Storage.put("knot_meter/second", value -> value * 0.514444);
        Converter_Storage.put("meter/second_knot", value -> value / 0.514444);
        Converter_Storage.put("knot_kilometer/hour", value -> value * 1.852);
        Converter_Storage.put("kilometer/hour_knot", value -> value / 1.852);
        Converter_Storage.put("mile/hour_kilometer/hour", value -> value * 1.60934);
        Converter_Storage.put("kilometer/hour_mile/hour", value -> value / 1.60934);
        Converter_Storage.put("terabyte_petabyte", value -> value / 1024.0);
        Converter_Storage.put("petabyte_terabyte", value -> value * 1024.0);
        Converter_Storage.put("petabyte_exabyte", value -> value / 1024.0);
        Converter_Storage.put("exabyte_petabyte", value -> value * 1024.0);
        Converter_Storage.put("bit_byte", value -> value / 8.0);
        Converter_Storage.put("byte_bit", value -> value * 8.0);
        Converter_Storage.put("byte_kibibyte", value -> value / 1024.0);
        Converter_Storage.put("kibibyte_byte", value -> value * 1024.0);
        Converter_Storage.put("kibibyte_mebibyte", value -> value / 1024.0);
        Converter_Storage.put("mebibyte_kibibyte", value -> value * 1024.0);
        Converter_Storage.put("mebibyte_gibibyte", value -> value / 1024.0);
        Converter_Storage.put("gibibyte_mebibyte", value -> value * 1024.0);
        Converter_Storage.put("gibibyte_tebibyte", value -> value / 1024.0);
        Converter_Storage.put("tebibyte_gibibyte", value -> value * 1024.0);

        String key = From_Unit.toLowerCase() + "_" + To_Unit.toLowerCase();
        if (Converter_Storage.containsKey(key)) {
            return Double.toString(Converter_Storage.get(key).apply(User_Value));
        }
        return "Conversion not supported!";
     }

     public static float Simple_Interest(float P, float R, float T) {
         return (P * R * T) / 100;
     }

     public static float Compound_Interest(float P, float R, float Year, float n){
        R /= 100;
        return (float) (P * Math.pow(1 + (R / n), n * Year)) - P;
     }

     public static String Replace_String(String Text, String Old, String New){
        return Text.replace(Old, New);
     }

     public static <T> T input(String message, Class<T> Type){
           final Scanner i = new Scanner(System.in);

           System.out.print(message);

           return switch (Type.getSimpleName()) {
                case "Integer"   -> Type.cast(i.nextInt());
                case "Double"    -> Type.cast(i.nextDouble());
                case "Float"     -> Type.cast(i.nextFloat());
                case "Long"      -> Type.cast(i.nextLong());
                case "Short"     -> Type.cast(i.nextShort());
                case "Byte"      -> Type.cast(i.nextByte());
                case "Boolean"   -> Type.cast(i.nextBoolean());
                case "String"    -> Type.cast(i.next());
                case "Character" -> Type.cast(i.next().charAt(0));
                default -> throw new IllegalArgumentException("Unsupported type: " + Type.getSimpleName());
            };
     }

     public static String Capital_First_Letter(String Text){
        return Text.substring(0, 1).toUpperCase() + Text.substring(1).toLowerCase();
     }

     public static double Find(String find, double... values){

        find = find.toLowerCase();
        double Answer = 0;

        Map<String, Function<double[], Double>> Find = new HashMap<>();

        Find.put("square perimeter", val -> val[0] * 4);
        Find.put("square area", val -> Math.pow(val[0], 2));
        Find.put("square diagonal", val -> Math.sqrt(2) * val[0]);

        Find.put("cube volume", val -> Math.pow(val[0], 3));
        Find.put("cube surface area", val -> 6 * Math.pow(val[0], 2));
        Find.put("cube space diagonal", val -> Math.sqrt(3) * val[0]);

        Find.put("rectangle perimeter", val -> 2 * (val[0] + val[1]));
        Find.put("rectangle area", val -> val[0] * val[1]);
        Find.put("rectangle diagonal", val -> Math.sqrt(Math.pow(val[0], 2) + Math.pow(val[1], 2)));

        Find.put("circle circumference", val -> 2 * Math.PI * val[0]);
        Find.put("circle area", val -> Math.PI * Math.pow(val[0], 2));
        Find.put("circle diameter", val -> 2 * val[0]);

        Find.put("sphere volume", val -> (4.0 / 3.0) * Math.PI * Math.pow(val[0], 3));
        Find.put("sphere surface area", val -> 4 * Math.PI * Math.pow(val[0], 2));

        Find.put("triangle area", val -> 0.5 * val[0] * val[1]);
        Find.put("triangle perimeter", val -> val[0] + val[1] + val[2]);
        Find.put("triangle semi perimeter", val -> (val[0] + val[1] + val[2]) / 2);
        Find.put("triangle heron area", val -> {
            double s = (val[0] + val[1] + val[2]) / 2;
            return Math.sqrt(s * (s - val[0]) * (s - val[1]) * (s - val[2]));
        });

        Find.put("parallelogram perimeter", val -> 2 * (val[0] + val[1]));
        Find.put("parallelogram area", val -> val[0] * val[1]);

        Find.put("trapezium perimeter", val -> val[0] + val[1] + val[2] + val[3]);
        Find.put("trapezium area", val -> 0.5 * (val[0] + val[1]) * val[2]);

        Find.put("ellipse perimeter", val -> Math.PI * (3 * (val[0] + val[1]) - Math.sqrt((3 * val[0] + val[1]) * (val[0] + 3 * val[1]))));
        Find.put("ellipse area", val -> Math.PI * val[0] * val[1]);

        Find.put("cylinder volume", val -> Math.PI * Math.pow(val[0], 2) * val[1]);
        Find.put("cylinder surface area", val -> 2 * Math.PI * val[0] * (val[0] + val[1]));

        Find.put("cone volume", val -> (1.0 / 3.0) * Math.PI * Math.pow(val[0], 2) * val[1]);
        Find.put("cone surface area", val -> Math.PI * val[0] * (val[0] + Math.sqrt(Math.pow(val[0], 2) + Math.pow(val[1], 2))));

        Find.put("pyramid volume", val -> (1.0 / 3.0) * val[0] * val[1] * val[2]);
        Find.put("pyramid surface area", val -> (val[0] * val[1]) + (val[0] * val[2]) + (val[1] * val[2]));

        Find.put("torus volume", val -> (2 * Math.PI * val[1]) * (Math.PI * Math.pow(val[0], 2)));
        Find.put("torus surface area", val -> 4 * Math.PI * Math.PI * val[0] * val[1]);

        Find.put("rhombus perimeter", val -> 4 * val[0]);
        Find.put("rhombus area", val -> 0.5 * val[0] * val[1]);

        Find.put("hexagon perimeter", val -> 6 * val[0]);
        Find.put("hexagon area", val -> (3 * Math.sqrt(3) / 2) * Math.pow(val[0], 2));

        Find.put("pentagon perimeter", val -> 5 * val[0]);
        Find.put("pentagon area", val -> (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(val[0], 2));

        Find.put("octagon perimeter", val -> 8 * val[0]);
        Find.put("octagon area", val -> 2 * (1 + Math.sqrt(2)) * Math.pow(val[0], 2));

        Find.put("sector area", val -> (val[1] / 360.0) * Math.PI * Math.pow(val[0], 2));
        Find.put("sector perimeter", val -> 2 * val[0] + (val[1] / 360.0) * 2 * Math.PI * val[0]);

        Find.put("frustum volume", val -> (1.0 / 3.0) * Math.PI * val[2] * (Math.pow(val[0], 2) + Math.pow(val[1], 2) + val[0] * val[1]));
        Find.put("frustum surface area", val -> Math.PI * (val[0] + val[1]) * Math.sqrt(Math.pow(val[2], 2) + Math.pow(val[0] - val[1], 2)) + Math.PI * Math.pow(val[0], 2) + Math.PI * Math.pow(val[1], 2));

        Find.put("dodecagon perimeter", val -> 12 * val[0]);
        Find.put("dodecagon area", val -> 3 * (2 + Math.sqrt(3)) * Math.pow(val[0], 2));

        Find.put("icosahedron volume", val -> (5.0 / 12.0) * (3 + Math.sqrt(5)) * Math.pow(val[0], 3));
        Find.put("icosahedron surface area", val -> 5 * Math.sqrt(3) * Math.pow(val[0], 2));

        Find.put("tetrahedron volume", val -> (Math.pow(val[0], 3)) / (6 * Math.sqrt(2)));
        Find.put("tetrahedron surface area", val -> Math.sqrt(3) * Math.pow(val[0], 2));

        Find.put("octahedron volume", val -> (Math.sqrt(2) / 3) * Math.pow(val[0], 3));
        Find.put("octahedron surface area", val -> 2 * Math.sqrt(3) * Math.pow(val[0], 2));

        if(Find.containsKey(find)) Answer = Find.get(find).apply(values);
        else System.out.println("Method Not Found!");

        return Answer;
     }

}
