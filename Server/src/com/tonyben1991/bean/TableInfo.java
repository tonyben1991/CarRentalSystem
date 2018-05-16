package com.tonyben1991.bean;

import java.util.Date;

/**
 * @author oaec
 * @date 2018-05-14
 **/
public interface TableInfo {
    interface User {
        String TABLE = "T_USER";
        String SEQ = "t_user_id_seq";
        String ID = TABLE + ".ID";
        String USER_NAME = TABLE + ".USERNAME";
        String PASSWORD = TABLE + ".PASSWORD";
        String GENDER = TABLE + ".GENDER";
        String ID_NUMBER = TABLE + ".ID_NUMBER";
        String TELEPHONE = TABLE + ".TELEPHONE";
        String ADDRESS = TABLE + ".ADDRESS";
        String TYPE = TABLE + ".TYPE";
    }

    interface Brand {
        String TABLE = "T_BRAND";
        String SEQ = "t_brand_id_seq";
        String ID = TABLE + ".ID";
        String NAME = TABLE + ".NAME";
    }

    interface Category {
        String TABLE = "T_CATEGORY";
        String SEQ = "t_category_id_seq";
        String ID = TABLE + ".ID";
        String NAME = TABLE + ".NAME";
    }

    interface Car {
        String TABLE = "T_CAR";
        String SEQ = "t_car_id_seq";
        String ID = TABLE + ".ID";
        String CAR_NUMBER = TABLE + ".CAR_NUMBER";
        String BRAND_ID = TABLE + ".BRAND_ID";
        String MODEL = TABLE + ".MODEL";
        String COLOR = TABLE + ".COLOR";
        String CATEGORY_ID = TABLE + ".CATEGORY_ID";
        String COMMENTS = TABLE + ".T_COMMENTS";
        String PRICE = TABLE + ".PRICE";
        String RENT = TABLE + ".RENT";
        String STATUS = TABLE + ".STATUS";
        String USEABLE = TABLE + ".USEABLE";
    }

    interface Record {
        String TABLE = "T_RECORD";
        String SEQ = "t_record_id_seq";
        String ID = TABLE + ".ID";
        String USER_ID = TABLE + ".USER_ID";
        String CAR_ID = TABLE + ".CAR_ID";
        String START_DATE = TABLE + ".START_DATE";
        String RETURN_DATE = TABLE + ".RETURN_DATE";
        String PAYMENT = TABLE + ".PAYMENT";
    }
}
