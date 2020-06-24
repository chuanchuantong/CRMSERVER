package com.j2eefast.flowable.bpm.enums;

public enum CommentTypeNameEnum {
    SP("审批中"),
    BH("已驳回"),
    CH("已撤回"),
    ZC("已暂存"),
    QS("已签收"),
    WP("已委派"),
    ZH("已知会"),
    ZY("已转阅"),
    YY("已阅"),
    ZB("已转办"),
    QJQ("前加签"),
    HJQ("后加签"),
    XTZX("系统执行"),
    TJ("已提交"),
    CXTJ("重新提交"),
    SPJS("审批结束"),
    LCZZ("流程已终止"),
    SQ("授权"),
    CFTG("重复跳过"),
    XT("协同"),
    PS("评审");
    private String name;//名称

    /**
     * 通过type获取Msg
     *
     * @param type
     * @return
     * @Description:
     */
    public static String getEnumMsgByType(String type) {
        for (CommentTypeNameEnum e : CommentTypeNameEnum.values()) {
            if (e.toString().equals(type)) {
                return e.name;
            }
        }
        return "";
    }
    private CommentTypeNameEnum(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
