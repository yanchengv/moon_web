package com.balawo.models.takeouts;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Time;

@Entity
//自动生成时间
@EntityListeners(AuditingEntityListener.class)
@Table(name="takeout_restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long admin_id;
    private Long boss_id;
    private Long department_id;
    private int status;
    private int delivery_fastest_time;
    private int delivery_slowest_time;
    private int is_breakfast;
    private int is_lunch;
    private int is_dinner;
    private Time breakfast_start_at;
    private Time breakfast_end_at;
    private Time lunch_start_at;
    private Time lunch_end_at;
    private Time dinner_start_at;
    private Time dinner_end_at;
    private int overall_star;
    private int comment_count;
    private String pay_type;
    private String big_img;
    private Double tableware_price;
    private Double package_price;
    @Lob //@Lob代表是长字段类型，默认的话，是longtext类型
    private String takeout_rule;
    @Lob
    private String remark;
    private int sort;
    private int like_count;
    private String phone;
    private String identifier;

}
