package com.dremio.planalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Metrics {
    boolean calc = false;
    private long min = 0;
    private long max = 0;
    private long sum = 0;
    private long counts = 0;

    String name;

    public Metrics(String name) {
        this.name = name;
    }

    public List<String> endPoints = new ArrayList<String>();
    public List<Long> dataPoints = new ArrayList<Long>();

    public void add(String endPoint, Long data) {
        endPoints.add(endPoint);
        dataPoints.add(data);
    }

    public String toString() {
        calc();
        if (name.contains("nano")) {
            return "[sum:" + formatTime(sum) + ", min:" + formatTime(min) + ", max:" + formatTime(max) + "]";
        } else {
            return "[sum:" + ProfileAnalyzer.NUMBER_FORMAT.format(sum) + ", min:" + ProfileAnalyzer.NUMBER_FORMAT.format(min) + ", max:" + ProfileAnalyzer.NUMBER_FORMAT.format(max) + "]";
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
        Long array[] = dataPoints.toArray(new Long[0]);
        Arrays.sort(array);
        long med = array[array.length / 2];
        double avg = (double) sum / array.length;
        double variance = 0;
        for (int i = 0; i < array.length; i++) {
            variance += Math.pow(array[i].longValue() - avg, 2);
        }
        variance = variance/array.length;
        double std = Math.sqrt(variance);
        double skewness = (3 * (avg - med)) / std;
        return skewness;
    }

    public static String formatTime(long nanos){
        StringBuffer sb = new StringBuffer();
        long seconds = nanos / 1000000000;
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
}
