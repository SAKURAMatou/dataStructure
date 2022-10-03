package com.dl.enumtest;

import java.util.Arrays;
import java.util.Optional;

public class EnumTest {
    public enum DayEnum2
    {
        Monday("星期一", Course.CHINESE),
        Tuesday("星期二", Course.CHINESE),
        Wednesday("星期三", Course.MATH),
        OTHERS("", Course.ENGLISH);

        private final String day;
        private final Course course;

        DayEnum2(String day, Course course) {
            this.day = day;
            this.course = course;
        }

        public static DayEnum2 getItemByday(String day) {
            Optional<DayEnum2> any = Arrays.stream(DayEnum2.values()).filter(item -> item.getDay().equals(day)).findAny();
            if (any.isPresent()) {
                return any.get();
            }
            return OTHERS;
        }

        public String getDay() {
            return day;
        }

        public Course getCourse() {
            return course;
        }

        String toDo() {
            return course.toDo();
        }

        private enum Course
        {
            ENGLISH
                    {
                        @Override
                        public String toDo() {
                            return "英语课程";
                        }
                    },
            CHINESE
                    {
                        @Override
                        public String toDo() {
                            return "中文课程";
                        }
                    },
            MATH
                    {
                        @Override
                        public String toDo() {
                            return "数学课程";
                        }
                    };

            public abstract String toDo();
        };
    }
}
