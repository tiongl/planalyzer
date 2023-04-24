package com.dremio.planalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Metrics {
    boolean calc = false;
    boolean calcSkew = false;
    private long min = 0;
    private long max = 0;
    private long sum = 0;
    private long counts = 0;

    private double skewness = 0;

    String name;

    public Metrics(String name) {
        this.name = name;
    }

    public List<String> endPoints = new ArrayList<String>();
    public List<Long> dataPoints = new ArrayList<Long>();

    public void add(String endPoint, Long data) {
        endPoints.add(endPoint);
        dataPoints.add(data);
        calc = false;
        calcSkew = false;
    }

    public String toString() {
        calc();
        if (name.contains("nano")) {
            return "[sum:" + formatTimeNanos(sum) + ", min:" + formatTimeNanos(min) + ", max:" + formatTimeNanos(max) + "]";
        } else if (name.contains("duration")) {
            return "[sum:" + formatTimeMillis(sum) + ", min:" + formatTimeMillis(min) + ", max:" + formatTimeMillis(max) + "]";
        } else {
            return "[sum:" + ProfileAnalyzer.NUMBER_FORMAT.format(sum) + ", min:" + ProfileAnalyzer.NUMBER_FORMAT.format(min) + ", max:" + ProfileAnalyzer.NUMBER_FORMAT.format(max) + "]";
        }
    }

    public String format(long value) {
        if (name.contains("nano")) {
            return formatTimeNanos(value);
        } else if (name.contains("memory")) {
            return formatMemory(value);
        }else if (name.contains("record")){
            return formatRowCount(value);
        } else {
            return ProfileAnalyzer.NUMBER_FORMAT.format(value);
        }
    }

    public static String formatRowCount(long value){
        if (value<1000){
            return value + "";
        } else if (value<1000000){
            return value/1000 + "K rows";
        } else if (value<1000000000){
            return value/1000000 + "M rows";
        } else return value/1000000000 + "B rows";
    }

    public static String formatMemory(long value){
        if (value<1000){
            return value + "";
        } else if (value<1000000){
            return value/1000 + "kb";
        } else if (value<1000000000){
            return value/1000000 + "mb";
        } else {
            return value/1000000000 + "gb";
        }
    }

    public void calc() {
        if (!calc) {
            for (int i = 0; i < dataPoints.size(); i++) {
                long data = dataPoints.get(i);
                sum += data;
                min = Math.min(data, min);
                max = Math.max(data, max);
            }
            counts = dataPoints.size();
            calc = true;
        }
    }

    public long sum() {
        calc();
        return sum;
    }

    public double skewness() {
        calc();
        calcSkew();
        return skewness;
    }

    public Long[] sortedData(){
        Long array[] = dataPoints.toArray(new Long[0]);
        Arrays.sort(array);
        return array;
    }

    public void calcSkew(){
        if (!calcSkew){
            Long[] array = sortedData();
            long med = array[array.length / 2];
            double avg = (double) sum / array.length;
            double variance = 0;
            for (int i = 0; i < array.length; i++) {
                variance += Math.pow(array[i].longValue() - avg, 2);
            }
            variance = variance/array.length;
            double std = Math.sqrt(variance);
            skewness = (3 * (avg - med)) / std;
//            calcSkew = true;
        }
    }

    public static String formatTimeNanos(long nanos) {
        return formatTimeMillis(nanos / 1000000);
    }

    public static String formatTimeMillis(long millis){
        StringBuffer sb = new StringBuffer();
        long seconds = millis / 1000;
        if (seconds>3600){
            sb.append((long)(seconds/3600) + "h");
            seconds %= 3600;
        }
        if (seconds>60){
            sb.append((long)(seconds/60) + "m");
            seconds %= 60;
        }
        if (seconds>0) {
            sb.append((long)seconds + "s");
        } else {
            sb.append((float)seconds/1000000000);
        }
        return sb.toString();
    }

    public long min() {
        calc();
        return min;
    }

    public long max() {
        calc();
        return max;
    }

    public long count(){
        calc();
        return counts;
    }

}
