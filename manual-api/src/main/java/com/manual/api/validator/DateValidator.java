package com.manual.api.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.ParseException;
import java.util.Date;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/09/26
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {DateValidator.DateValidatorInner.class})
public @interface DateValidator {

    Logger logger = LoggerFactory.getLogger(DateValidator.class);
    /**
     * 必须的属性
     * 显示 校验信息
     * 利用 {} 获取 属性值，参考了官方的message编写方式
     *
     * @see org.hibernate.validator 静态资源包里面 message 编写方式
     */
    String message() default "日期格式不匹配{dateFormat}";

    /**
     * 必须的属性
     * 用于分组校验
     */
    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};

    /**
     * 非必须
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 必须实现 ConstraintValidator接口
     */
    class DateValidatorInner implements ConstraintValidator<DateValidator, String>{
        private String dateFormat;

        @Override
        public void initialize(DateValidator constraintAnnotation) {
            this.dateFormat = constraintAnnotation.dateFormat();
        }

        /**
         * 校验逻辑的实现
         *
         * @param value 需要校验的 值
         * @return 布尔值结果
         */
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (StringUtils.isBlank(value)) return true;

            try {
                Date date = DateUtils.parseDate(value, dateFormat);
                return null != date;
            } catch (ParseException e) {
                logger.error("date format error, format:{}, value:{}", dateFormat, value);
                return false;
            }
        }
    }
}
