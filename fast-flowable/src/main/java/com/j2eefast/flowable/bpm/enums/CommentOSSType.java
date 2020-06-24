package com.j2eefast.flowable.bpm.enums;

public enum CommentOSSType {
    /**
     * 驾照
     */
    DL(1),
    /**
     * 护照
     */
    PP(2);

    /**
     * 名称
     */
    private Integer name;

    /**
     * 通过type获取Msg
     *
     * @param type
     * @return
     * @Description:
     */
    public static Integer getCommentOSSTypeByType(String type) {
        for (CommentOSSType e : CommentOSSType.values()) {
            if (e.toString().equals(type)) {
                return e.name;
            }
        }
        return -1;
    }
    private CommentOSSType(Integer name) {
        this.name = name;
    }
    public Integer getName() {
        return name;
    }
    public void setName(Integer name) {
        this.name = name;
    }
}
