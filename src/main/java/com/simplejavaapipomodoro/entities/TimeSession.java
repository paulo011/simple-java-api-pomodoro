package com.simplejavaapipomodoro.entities;

import lombok.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class TimeSession {
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    public TimeSession(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeSession(String stringTime){
        List<Integer> listTime = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(stringTime);
        while (matcher.find()){
            String timeStr = matcher.group();
            Integer timeInt = Integer.parseInt(timeStr);
            listTime.add(timeInt);
        }
        this.hours = listTime.get(0);
        this.minutes = listTime.get(1);
        this.seconds = listTime.get(2);
    }

    public String concatenateTime(TimeSession timeSession){
        Duration duration1 = Duration
                .ofHours(timeSession.getHours())
                .plusMinutes(timeSession.getMinutes())
                .plusSeconds(timeSession.getSeconds());

        Duration duration2 = Duration
                .ofHours(this.getHours())
                .plusMinutes(this.getMinutes())
                .plusSeconds(this.getSeconds());

        Duration concat = duration1.plus(duration2);

        this.hours = (int) concat.toHours();
        this.minutes = concat.toMinutesPart();
        this.seconds = concat.toSecondsPart();

        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
