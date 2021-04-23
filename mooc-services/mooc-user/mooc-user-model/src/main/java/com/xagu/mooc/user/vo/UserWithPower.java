package com.xagu.mooc.user.vo;

import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.pojo.User;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xagu
 * Created on 2020/6/8
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserWithPower extends User {

    List<Power> powers;

    private static final long serialVersionUID = 1L;
}
