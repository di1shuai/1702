/**
 * 常量类
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/7/25
 */
public class CommonConstant {

    /**
     *账目分摊状态  0：不需要分摊  1：未分摊  2：已分摊
     */
    private final static  Byte SHARE_STATUS_NOT_NEED = 0;
    private final static  Byte SHARE_STATSU_NOT_YET = 1;
    private final static  Byte SHARE_STATSU_FINISH = 2;

    /**
     * 账目状态 0：分摊  1：指向（借款）
     */
    private final static  Byte STRATEGY_SHARE = 0;
    private final static  Byte STRATEGY_LOAN = 1;

    /**
     * 账目类型 0：消费  1：借款
     */
    private final static Byte ACCOUNT_TYPE_SPEND = 0;
    private final static Byte ACCOUNT_TYPE_LOAN = 1;

    /**
     * 个人账目处理状态
     * 状态  0：待处理  1：已处理
     */
    private final static Byte ACCOUNT_HANDLE_STATUS_NOT = 0;
    private final static Byte ACCOUNT_HANDLE_STATUS_FINISH = 1;

    /**
     * 统一返回码 0：失败 1：成功
     */
    private final static Integer RETURN_CODE_SUCCESS = 1;
    private final static Integer RETURN_CODE_FAIL = 0;

}
