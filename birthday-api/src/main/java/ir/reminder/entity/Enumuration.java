package ir.reminder.entity;

public enum Enumuration {

    LATIN_FIRST_NAME_NOT_NULL(100,"فیلد نام انگلیسی نمی تواند خالی ارسال شود."),
    LATIN_LAST_NAME_NOT_NULL(101,"فیلد نام خانوادگی انگلیسی نمی تواند خالی ارسال شود."),
    NATIONAL_CODE_ONLY_ACC_NUM(102,"فیلد  کد ملی  تنها عدد می پذیرد."),
    NATIONAL_CODE_LENGTH_INVALID(103,"طول  کد ملی درست نیست."),
    NATIONAL_CODE_NOT_NULL(104,"فیلد  کد ملی  نمی تواند خالی ارسال شود."),
    GENDER_IS_INVALID(105, "فیلد جنسیت نا معتبر می باشد ."),
    EMAIL_NOT_NULL(106,"فیلد ایمیل نمی تواند خالی باشد."),
    EMAIL_NOT_VALID(107,"فیلد ایمیل معتبر نمی باشد."),
    PASSWORD_LENGTH_INVALID(108, "طول فیلد رمزعبور نامعتبر است."),
    USERNAME_LENGTH_INVALID(109, "طول فیلد شناسه کاربری نامعتبر است."),
    USER_NAME_NOT_BLANK(110,"فیلد نام کاربری نمیتواند خالی ارسال شود.") ;

    private int value;
    private String title;

    private Enumuration(int value) {
        this.value = value;
    }

    private Enumuration(int value, String title) {
        this.value = value;
        this.title = title;
    }


    public int toValue() {
        return this.value;
    }

    public String getTitle() {
        return this.title;
    }
    public int getValue() {
        return value;
    }
}
